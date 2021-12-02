package com.etiya.ReCapProject.business.concretes;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.ReCapProject.business.abstracts.CreditCardService;
import com.etiya.ReCapProject.business.constants.Messages;
import com.etiya.ReCapProject.business.requests.creditCardRequests.CreateCreditCardRequest;
import com.etiya.ReCapProject.business.requests.creditCardRequests.DeleteCreditCardRequest;
import com.etiya.ReCapProject.business.requests.creditCardRequests.UpdateCreditCardRequest;
import com.etiya.ReCapProject.core.utilities.business.BusinessRules;
import com.etiya.ReCapProject.core.utilities.mapping.ModelMapperService;
import com.etiya.ReCapProject.core.utilities.results.ErrorResult;
import com.etiya.ReCapProject.core.utilities.results.Result;
import com.etiya.ReCapProject.core.utilities.results.SuccessResult;
import com.etiya.ReCapProject.dataAccess.abstracts.CreditCardDao;
import com.etiya.ReCapProject.entities.concretes.CreditCard;

@Service
public class CreditCardManager implements CreditCardService {
	private CreditCardDao creditCardDao;
	private ModelMapperService modelMapperService;

	@Autowired
	public CreditCardManager(CreditCardDao creditCardDao, ModelMapperService modelMapperService) {
		super();
		this.creditCardDao = creditCardDao;
		this.modelMapperService = modelMapperService;
	}
	@Override
	public Result delete(DeleteCreditCardRequest deleteCreditCardRequest) {
		CreditCard creditCard = modelMapperService.forRequest().map(deleteCreditCardRequest, CreditCard.class);
		this.creditCardDao.save(creditCard);
		return new SuccessResult(Messages.CREDITCARDELETE);
	}

	@Override
	public Result update(UpdateCreditCardRequest updateCreditCardRequest) {
		CreditCard creditCard = modelMapperService.forRequest().map(updateCreditCardRequest, CreditCard.class);
		this.creditCardDao.save(creditCard);
		return new SuccessResult(Messages.CREDITCARDUPDATE);
	}

	@Override
	public Result add(CreateCreditCardRequest createCreditCardRequest) {
		Result result=BusinessRules.run(checkCreditCardNumber(createCreditCardRequest.getCardNumber()));
		if (result!=null) {
			return result;
		}
		CreditCard creditCard = modelMapperService.forRequest().map(createCreditCardRequest, CreditCard.class); 
		this.creditCardDao.save(creditCard);
		return new SuccessResult(Messages.CREDITCARDADD);
	}
	
	private Result checkCreditCardNumber(String cardNumber) {
		String regex = "((?:(?:\\d{4}[- ]){3}\\d{4}|\\d{16}))(?![\\d])";
		Pattern pattern = Pattern.compile(regex);
		java.util.regex.Matcher matcher = pattern.matcher(cardNumber);
		if (!matcher.matches()) {
			return new ErrorResult(Messages.CREDITCARDNUMBERERROR);
		}
		return new SuccessResult();
	}
}
