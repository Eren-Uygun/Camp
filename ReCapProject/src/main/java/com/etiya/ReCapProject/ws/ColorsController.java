package com.etiya.ReCapProject.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.ReCapProject.business.abstracts.ColorService;
import com.etiya.ReCapProject.business.dtos.ColorSearchListDto;
import com.etiya.ReCapProject.business.requests.colorRequests.CreateColorRequest;
import com.etiya.ReCapProject.business.requests.colorRequests.DeleteColorRequest;
import com.etiya.ReCapProject.business.requests.colorRequests.UpdateColorRequest;
import com.etiya.ReCapProject.core.utilities.results.DataResult;
import com.etiya.ReCapProject.core.utilities.results.Result;



@RestController
@RequestMapping("/api/colors")
public class ColorsController {
	
	private ColorService colorService;

	@Autowired
	public ColorsController(ColorService colorService) {
		super();
		this.colorService = colorService;
	}
	@GetMapping("getAll")
	public DataResult<List<ColorSearchListDto>> getAll(){
		return this.colorService.getAll();
	}
	@DeleteMapping("delete")
	public Result delete(@RequestBody DeleteColorRequest deleteColorRequest) {
		return this.colorService.delete(deleteColorRequest);
	}
	
	@PutMapping("update")
	public Result update(@RequestBody UpdateColorRequest updateColorRequest){
		return this.colorService.update(updateColorRequest);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CreateColorRequest createColorRequest){
		return this.colorService.add(createColorRequest);
	}
	
	@GetMapping("/getColor")
	public DataResult<ColorSearchListDto> getColor(int id){
		return this.colorService.getByColorId(id);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
