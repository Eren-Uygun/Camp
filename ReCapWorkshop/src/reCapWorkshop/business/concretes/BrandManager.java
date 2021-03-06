package reCapWorkshop.business.concretes;

import java.util.List;

import reCapWorkshop.business.abstracts.BrandService;
import reCapWorkshop.core.utilities.results.DataResult;
import reCapWorkshop.core.utilities.results.Result;
import reCapWorkshop.dataAccess.abstracts.BrandRepository;
import reCapWorkshop.entities.concretes.Brand;

public class BrandManager implements BrandService {
	
	private BrandRepository brandRepository;
	
	public BrandManager(BrandRepository brandRepository) {
		this.brandRepository = brandRepository;
	}

	@Override
	public Result add(Brand entity) {
		
		return brandRepository.add(entity);
	}

	@Override	
	public Result update(Brand entity,int id) {
		
		return brandRepository.update(entity,id);
	}

	@Override
	public Result delete(Brand entity) {
		return brandRepository.delete(entity);
	}

	@Override
	public DataResult<Brand> getById(int id) {
		
		return brandRepository.getById(id);
	}

	@Override
	public DataResult<List<Brand>> getAll() {
		// TODO Auto-generated method stub
		return brandRepository.getAll();
	}

}
