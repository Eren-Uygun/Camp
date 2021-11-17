package reCapWorkshop.business.concretes;

import java.util.List;

import reCapWorkshop.business.abstracts.CarService;
import reCapWorkshop.core.utilities.results.DataResult;
import reCapWorkshop.core.utilities.results.Result;
import reCapWorkshop.dataAccess.abstracts.CarRepository;
import reCapWorkshop.entities.concretes.Car;

public class CarManager implements CarService {
	
	private CarRepository carRepository;
	

	public CarManager(CarRepository carRepository) {
		this.carRepository = carRepository;
	}

	@Override
	public Result add(Car entity) {
		return carRepository.add(entity);
	}

	@Override
	public Result update(Car entity,int id) {
		// TODO Auto-generated method stub
		return carRepository.update(entity,id);
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
		// TODO Auto-generated method stub
		return carRepository.getAll();
	}

}
