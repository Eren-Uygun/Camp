package com.appsdeveloperblog.photoapp.api;

import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import javax.ws.rs.core.HttpHeaders;

@Component //Bu class sistem açıldığınca configuration olarak algılanıyor.
public class AuthorizationHeaderFilter extends AbstractGatewayFilterFactory {
	//Bu sistem güvenlik site örneğinin doğrulama bölümüdür.

	@Autowired
	private Environment environment;



	
	//filter bir aop tekniğidir.Sistem ilk bunu çalıştırır.
	//ÖRneğin user'a gitme önce buraya gel demek.
	
	@Override
	public GatewayFilter apply(Object config) {
		//Amaç Frondend'den istekgeldiğinde token geçerliyle gateway'den geçer.
		//Bu bölüm update ve delete için devreye girsin.Ancak register ve login için devreye girmesin.
		//Gateway'in ana dosyasında mono<Void> olan yer reactive programming - bir requestin yaşam döngüsünü sağlayan yapı

		//exchange yapılan request(istek)





		return (exchange, chain) -> {
			//Reactive prog uyguladığımız zaman exchange ve chain parametreleri geldiğinde exchange'i zincirin filtresine ekle
			ServerHttpRequest request = exchange.getRequest();
			if (!request.getHeaders().containsKey(HttpHeaders.AUTHORIZATION))
			{
				return onError(exchange,"No Auth Header", HttpStatus.UNAUTHORIZED);
			}

			String authorizationHeader = request.getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);

			String jwt = authorizationHeader.replace("Bearer",""); //Bearer'i siler.Token'i jwt'ye atar.

			if (!isJwtValid(jwt)){
				return onError(exchange,"JWT is not valid", HttpStatus.UNAUTHORIZED);
			}



			return chain.filter(exchange);

		};

	}

	private Mono<Void> onError(ServerWebExchange exchange, String error, HttpStatus httpStatus) {

		ServerHttpResponse response = exchange.getResponse();
		response.setStatusCode(httpStatus);
		return response.setComplete();
	}

	private boolean isJwtValid(String jwt){
		boolean returnValue = true;

		//Jwts -> Cavts diye okunur.
	  String subject =	Jwts.parser().setSigningKey(this.environment.getProperty("token.secret"))
				.parseClaimsJws(jwt)
				.getBody()
				.getSubject();

	  if (subject == null || subject.isEmpty()){
		  return false;
	  }


		return returnValue;


	}


}
