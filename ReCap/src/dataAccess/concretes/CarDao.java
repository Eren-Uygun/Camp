package dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import core.utilities.results.DataResult;
import core.utilities.results.Result;
import core.utilities.results.SuccessDataResult;
import core.utilities.results.SuccessResult;
import dataAccess.abstracts.CarRepository;
import entities.Car;

public class CarDao implements CarRepository {
	
	private List<Car> cars;
	
	

	public CarDao() {
		cars = new ArrayList<Car>();
	}

	@Override
	public Result insert(Car entity) {
		cars.add(entity);
		return new SuccessResult("Veri tabanına eklendi.");
	}

	@Override
	public Result update(Car entity) {
		cars.set(entity.getBrandId(), entity);
		return new SuccessResult("İlgili veri ve güncellendi.");
	}

	@Override
	public Result delete(Car entity) {
		cars.remove(entity);
		return new SuccessResult("Veri veritabanından silindi.");
	}

	@Override
	public DataResult<Car> getById(int id) {
		return new SuccessDataResult<Car>(cars.get(id),"Veri veri tabanından id ile getirildi.");
	}

	@Override
	public DataResult<List<Car>> getAll() {
		return new SuccessDataResult<List<Car>>(cars,"Veriler getirildi.");
	}

}
