package business.concretes;

import java.util.List;

import business.abstracts.CarService;
import core.utilities.results.DataResult;
import core.utilities.results.Result;
import dataAccess.abstracts.CarRepository;
import entities.Car;

public class CarManager implements CarService {
	
	private CarRepository carRepository;

	public CarManager(CarRepository carRepository) {
		super();
		this.carRepository = carRepository;
	}

	@Override
	public Result insert(Car entity) {
		// TODO Auto-generated method stub
		return carRepository.insert(entity);
	}

	@Override
	public Result update(Car entity) {
		// TODO Auto-generated method stub
		return carRepository.update(entity);
	}

	@Override
	public Result delete(Car entity) {
	
		return carRepository.delete(entity);
	}

	@Override
	public DataResult<Car> getById(int id) {
		// TODO Auto-generated method stub
		return carRepository.getById(id);
	}

	@Override
	public DataResult<List<Car>> getAll() {
		
		return carRepository.getAll();
	}

}
