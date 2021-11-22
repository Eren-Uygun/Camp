package reCapWorkshop.business.abstracts;

import java.util.List;

import reCapWorkshop.core.utilities.results.DataResult;
import reCapWorkshop.core.utilities.results.Result;
import reCapWorkshop.entities.concretes.Brand;

public interface BrandService {
	
	Result add(Brand entity);
	Result update(Brand entity , int id);
	Result delete(Brand entity);
	DataResult<Brand> getById(int id);
	DataResult<List<Brand>> getAll();

	
	
}
