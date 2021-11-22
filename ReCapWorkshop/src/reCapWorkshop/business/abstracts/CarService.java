package reCapWorkshop.business.abstracts;

import java.util.List;

import reCapWorkshop.core.utilities.results.DataResult;
import reCapWorkshop.core.utilities.results.Result;
import reCapWorkshop.entities.concretes.Brand;
import reCapWorkshop.entities.concretes.Car;

public interface CarService{
	
	Result add(Car entity);
	Result update(Car entity , int id);
	Result delete(Car entity);
	DataResult<Car> getById(int id);
	DataResult<List<Car>> getAll();

}
