package dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

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
		brands.set(entity.getBrandId(), entity);
		return new SuccessResult("Marka güncellendi.");
	}

	@Override
	public Result delete(Brand entity) {
		brands.remove(entity);
	
		return new SuccessResult("Marka silindi.");
	}

	@Override
	public DataResult<Brand> getById(int id) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<Brand>(brands.get(id),"Marka id ile getirildi.");
	}

	@Override
	public DataResult<List<Brand>> getAll() {
		return new SuccessDataResult<List<Brand>>(brands,"Veri getirildi.");
	}

}
