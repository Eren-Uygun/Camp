package com.etiya.northwindSpring.core.utils.business;

import com.etiya.northwindSpring.core.utils.results.Result;

public class BusinessRules {
	//Statik metotlar newlemeden kullanılabilir.
	//Statik metotlar uygulama açıldığından itibaren bellekde durur buda sistemi yavaşlatır.
	
	public static Result run(Result ...logics) {
		//Tüm gönderilen logic'leri dolaşır.// ... javascriptdeki spread metodudur.Gönderilen veriler arraye dönüşür.
		for (Result logic : logics) {
			if (!logic.isSuccess()) {
				return logic;
			}
		}
		return null;
		
	}

}

//BusinessRules.run(logic1,logic2,logic3);
//PRoblem varsa hata ver yoksa null dön.


// if içi result dönme sebebi mesaj vermektir.
