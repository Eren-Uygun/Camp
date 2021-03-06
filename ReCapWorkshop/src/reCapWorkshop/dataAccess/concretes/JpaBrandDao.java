package reCapWorkshop.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import reCapWorkshop.core.utilities.results.DataResult;
import reCapWorkshop.core.utilities.results.Result;
import reCapWorkshop.core.utilities.results.SuccessDataResult;
import reCapWorkshop.core.utilities.results.SuccessResult;
import reCapWorkshop.dataAccess.abstracts.BrandRepository;
import reCapWorkshop.entities.concretes.Brand;

public class JpaBrandDao implements BrandRepository {
	
	List<Brand> brands;
	
	public JpaBrandDao() {
		brands = new ArrayList<Brand>();
	}

	@Override
	public Result add(Brand entity) {
		
		brands.add(entity);
		return new SuccessResult("Model eklendi");
	}

	@Override
	public Result update(Brand entity,int id) {
		
		var tempBrand = brands.get(id);
		tempBrand.setBrandName(entity.getBrandName());
		brands.set(entity.getBrandId(), entity);
		return new SuccessResult("Model bilgisi ");
	}

	@Override
	public Result delete(Brand entity) {
		brands.remove(entity);
		return new SuccessResult("Model Silindi.");
	}

	@Override
	public DataResult<Brand> getById(int id) {
		return new SuccessDataResult<Brand>(brands.get(id), "Id'li veri getirildi.");
	}

	@Override
	public DataResult<List<Brand>> getAll() {
		return new SuccessDataResult<List<Brand>>(brands,"Veriler getirildi.");
	}

}
