package com.etiya.ReCapProject.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.ReCapProject.business.abstracts.CreditCardService;
import com.etiya.ReCapProject.business.requests.creditCardRequests.CreateCreditCardRequest;import com.etiya.ReCapProject.core.utilities.results.Result;

@RestController
@RequestMapping("api/creditcards")
public class CreditCardsController {
	
	private CreditCardService creditCardService;

	@Autowired
	public CreditCardsController(CreditCardService creditCardService) {
		super();
		this.creditCardService = creditCardService;
	}
	
	@PostMapping("add")
	public Result add(CreateCreditCardRequest createCreditCardRequest) {
		return this.creditCardService.add(createCreditCardRequest);
	}
	
}
