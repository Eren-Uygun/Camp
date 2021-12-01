package com.etiya.ReCapProject.business.concretes;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.ReCapProject.business.abstracts.InvoiceService;
import com.etiya.ReCapProject.business.constants.Messages;
import com.etiya.ReCapProject.business.dtos.InvoiceSearchListDto;
import com.etiya.ReCapProject.business.requests.invoiceRequests.CreateInvoiceRequest;
import com.etiya.ReCapProject.business.requests.invoiceRequests.DeleteInvoiceRequest;
import com.etiya.ReCapProject.business.requests.invoiceRequests.UpdateInvoiceRequest;
import com.etiya.ReCapProject.core.utilities.mapping.ModelMapperService;
import com.etiya.ReCapProject.core.utilities.results.DataResult;
import com.etiya.ReCapProject.core.utilities.results.Result;
import com.etiya.ReCapProject.core.utilities.results.SuccessDataResult;
import com.etiya.ReCapProject.core.utilities.results.SuccessResult;
import com.etiya.ReCapProject.dataAccess.abstracts.InvoiceDao;
import com.etiya.ReCapProject.entities.concretes.Car;
import com.etiya.ReCapProject.entities.concretes.Invoice;
import com.etiya.ReCapProject.entities.concretes.complexTypes.CarBrandDetail;

@Service
public class InvoiceManager implements InvoiceService {
	private InvoiceDao invoiceDao;
	private ModelMapperService modelMapperService;

	@Autowired
	public InvoiceManager(InvoiceDao invoiceDao, ModelMapperService modelMapperService) {
		super();
		this.invoiceDao = invoiceDao;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public DataResult<List<InvoiceSearchListDto>> getAll() {
		List<Invoice> invoices=this.invoiceDao.findAll();
		List<InvoiceSearchListDto> invoiceSearchListDtos=invoices.stream()
				.map(invoice->modelMapperService.forDto().map(invoice, InvoiceSearchListDto.class)).collect(Collectors.toList());
		return new SuccessDataResult<List<InvoiceSearchListDto>>(invoiceSearchListDtos);
	}

	@Override
	public Result add(CreateInvoiceRequest createInvoiceRequest) {
		int totalDay= (int)(ChronoUnit.DAYS.between(createInvoiceRequest.getRentDate(), createInvoiceRequest.getReturnDate()));
		createInvoiceRequest.setTotalRentDay(totalDay);
		createInvoiceRequest.setCreateDate(LocalDate.now());
		Invoice invoice=modelMapperService.forRequest().map(createInvoiceRequest, Invoice.class);
		this.invoiceDao.save(invoice);
		return new SuccessResult(Messages.INVOICEADD);
	}

	@Override
	public Result delete(DeleteInvoiceRequest deleteInvoiceRequest) {
		Invoice invoice=modelMapperService.forRequest().map(deleteInvoiceRequest, Invoice.class);
		this.invoiceDao.delete(invoice);
		return new SuccessResult(Messages.INVOICEDELETE);
	}

	@Override
	public Result update(UpdateInvoiceRequest updateInvoiceRequest) {
		Invoice invoice=modelMapperService.forRequest().map(updateInvoiceRequest, Invoice.class);
		this.invoiceDao.save(invoice);
		return new SuccessResult(Messages.INVOICEUPDATE);
	}

	@Override
	public DataResult<List<InvoiceSearchListDto>> getByCustomerId(int customerId) {
		
		List<Invoice> invoices=this.invoiceDao.getByCustomer_Id(customerId);
		List<InvoiceSearchListDto> invoiceSearchListDtos=invoices.stream()
				.map(invoice -> modelMapperService.forDto().map(invoice, InvoiceSearchListDto.class)).collect(Collectors.toList());
		return new SuccessDataResult<List<InvoiceSearchListDto>>(invoiceSearchListDtos);
	}

	@Override
	public DataResult<List<InvoiceSearchListDto>> getByCreateDateBetweenBeginDateAndEndDate(LocalDate beginDate,
			LocalDate endDate) {
		List<Invoice> invoices=this.invoiceDao.getByCreateDateBetween(beginDate, endDate);
		List<InvoiceSearchListDto> invoiceSearchListDtos=invoices.stream()
				.map(invoice -> modelMapperService.forDto().map(invoice, InvoiceSearchListDto.class)).collect(Collectors.toList());
		return new SuccessDataResult<List<InvoiceSearchListDto>>(invoiceSearchListDtos);
	}
}
