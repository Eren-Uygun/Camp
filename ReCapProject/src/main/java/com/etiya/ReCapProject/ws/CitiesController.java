package com.etiya.ReCapProject.ws;

import com.etiya.ReCapProject.business.abstracts.CityService;
import com.etiya.ReCapProject.business.dtos.CitySearchListDto;
import com.etiya.ReCapProject.business.requests.cityRequests.CreateCityRequest;
import com.etiya.ReCapProject.business.requests.cityRequests.DeleteCityRequest;
import com.etiya.ReCapProject.business.requests.cityRequests.UpdateCityRequest;
import com.etiya.ReCapProject.core.utilities.results.DataResult;
import com.etiya.ReCapProject.core.utilities.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
public class CitiesController {

    private CityService cityService;
    @Autowired
    public CitiesController(CityService cityService){
        this.cityService = cityService;
    }

    @PostMapping("/add")
    public Result add(CreateCityRequest createCityRequest){
    return this.cityService.add(createCityRequest);
    }

    @PutMapping("/update")
    public Result update(UpdateCityRequest updateCityRequest){
return this.cityService.update(updateCityRequest);
    }

    @DeleteMapping("/delete")
    public Result delete (DeleteCityRequest deleteCityRequest){
    return this.cityService.delete(deleteCityRequest);
    }

    @GetMapping("/getAll")
        public DataResult<List<CitySearchListDto>> getAll(){
    return this.cityService.getAll();
        }

        @GetMapping("/getByCityId")
        public DataResult<CitySearchListDto> getByCityId(int id){
     return this.cityService.getById(id);
        }


}
