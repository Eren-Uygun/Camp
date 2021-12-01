package com.etiya.ReCapProject.ws;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.ReCapProject.business.abstracts.InvoiceService;
import com.etiya.ReCapProject.business.dtos.InvoiceSearchListDto;
import com.etiya.ReCapProject.business.requests.invoiceRequests.CreateInvoiceRequest;
import com.etiya.ReCapProject.business.requests.invoiceRequests.DeleteInvoiceRequest;
import com.etiya.ReCapProject.business.requests.invoiceRequests.UpdateInvoiceRequest;
import com.etiya.ReCapProject.core.utilities.results.DataResult;
import com.etiya.ReCapProject.core.utilities.results.Result;


@RestController
@RequestMapping("api/invoices")
public class InvoicesController {
	private InvoiceService invoiceService;

	@Autowired
	public InvoicesController(InvoiceService invoiceService) {
		super();
		this.invoiceService = invoiceService;
	}

	@GetMapping("getAll")
	public DataResult<List<InvoiceSearchListDto>> getAll() {
		return this.invoiceService.getAll();
	}

	@PostMapping("add")
	public Result add(@RequestBody CreateInvoiceRequest createInvoiceRequest) {
		return this.invoiceService.add(createInvoiceRequest);
	}

	@PutMapping("update")
	public Result update(@RequestBody UpdateInvoiceRequest updateInvoiceRequest) {
		return this.invoiceService.update(updateInvoiceRequest);
	}

	@DeleteMapping("delete")
	public Result update(@RequestBody DeleteInvoiceRequest deleteInvoiceRequest) {
		return this.invoiceService.delete(deleteInvoiceRequest);
	}

	@GetMapping("getByCustomerId")
	public DataResult<List<InvoiceSearchListDto>> getByCustomerId(@RequestParam int customerId) {
		return this.invoiceService.getByCustomerId(customerId);
	}
	
	@GetMapping("getByCreateDateBetweenBeginDateAndEndDate")
	public DataResult<List<InvoiceSearchListDto>> getByCreateDateBetweenBeginDateAndEndDate(@RequestParam LocalDate beginDate, @RequestParam LocalDate endDate) {
		return this.invoiceService.getByCreateDateBetweenBeginDateAndEndDate(beginDate, endDate);
	}
}
