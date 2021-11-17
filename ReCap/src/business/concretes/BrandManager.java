package business.concretes;

import java.util.List;

import business.abstracts.BrandService;
import core.utilities.results.DataResult;
import core.utilities.results.Result;
import core.utilities.results.SuccessDataResult;
import core.utilities.results.SuccessResult;
import dataAccess.abstracts.BrandRepository;
import entities.Brand;

public class BrandManager implements BrandService{
	
	private BrandRepository brandRepository;
	
	public BrandManager(BrandRepository brandRepository) {
		super();
		this.brandRepository = brandRepository;
	}

	@Override
	public Result insert(Brand entity) {
		return brandRepository.insert(entity);
	}

	@Override
	public Result update(Brand entity) {
		return brandRepository.update(entity);
	
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
		return brandRepository.getAll();
	}

}
