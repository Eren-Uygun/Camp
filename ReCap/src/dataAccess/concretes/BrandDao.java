package dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import core.utilities.results.DataResult;
import core.utilities.results.Result;
import core.utilities.results.SuccessDataResult;
import core.utilities.results.SuccessResult;
import dataAccess.abstracts.BrandRepository;
import entities.Brand;

public class BrandDao implements BrandRepository {
	
	private List<Brand> brands;
	
	

	public BrandDao() {
		brands = new ArrayList<Brand>();
	}

	@Override
	public Result insert(Brand entity) {
		brands.add(entity);
		return new SuccessResult("Marka veritabanına eklendi.");
	}

	@Override
	public Result update(Brand entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result delete(Brand entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<Brand> getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<Brand>> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
