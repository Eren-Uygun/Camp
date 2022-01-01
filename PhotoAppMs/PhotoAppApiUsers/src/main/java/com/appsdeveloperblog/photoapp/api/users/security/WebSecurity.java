package com.appsdeveloperblog.photoapp.api.users.security;
import javax.servlet.Filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.appsdeveloperblog.photoapp.api.users.business.abstracts.UserService;

@Configuration //Endpointler
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {
	
	//Cors başja bir domainden istek geldiğinde izin vermez yapılandırmamız gerekir.
	//Csrf ise OASP güvenlikde izin verilen clientlerin ilgili, izin verilen bölümlerinden istek yapılabilir.
	//cross side request forgery =>
	
	private Environment environment;	
	private UserService userService;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	public WebSecurity(Environment environment, UserService userService, BCryptPasswordEncoder bCryptPasswordEncoder) {
		super();
		this.environment = environment;
		this.userService = userService;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		//Apiler default olarak seasurf ataklarına kapalı gelir.
		
		http.csrf().disable();
		//Permission kodu
		http.authorizeRequests().antMatchers("/**").hasIpAddress(this.environment.getProperty("gateway.ip")).and().addFilter(getAuthenticationFilter()); 
		http.headers().frameOptions().disable();
	}

	private AuthenticationFilter getAuthenticationFilter() throws Exception {
		AuthenticationFilter authenticationFilter = new AuthenticationFilter(this.userService,environment,authenticationManager());
		//authenticationFilter.setFilterProcessesUrl("users/login"); //İşlem yaptığımuz url'yi değiştirmemizi sağlar.
		
		authenticationFilter.setFilterProcessesUrl(this.environment.getProperty("login.url.path"));
		//Burada Spring security'i kullanacağımızı söylüyoruz.
		//authenticationFilter.setAuthenticationManager(authenticationManager());
		return authenticationFilter;
	}
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(this.userService).passwordEncoder(bCryptPasswordEncoder);
	}
	
	
	
	
	
	
	
	

}


//Gerçek hayatta her servis ayrı ip le oluyor.