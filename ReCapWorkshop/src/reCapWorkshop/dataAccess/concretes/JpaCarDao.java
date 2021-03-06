package reCapWorkshop.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import reCapWorkshop.core.utilities.results.DataResult;
import reCapWorkshop.core.utilities.results.Result;
import reCapWorkshop.core.utilities.results.SuccessDataResult;
import reCapWorkshop.core.utilities.results.SuccessResult;
import reCapWorkshop.dataAccess.abstracts.CarRepository;
import reCapWorkshop.entities.concretes.Car;

public class JpaCarDao implements CarRepository {
	
	private List<Car> cars;

	public JpaCarDao() {
		cars = new ArrayList<Car>();
	}

	@Override
	public Result add(Car entity) {
		cars.add(entity);
		return new SuccessResult("Araba eklendi.");
	}

	@Override
	public Result update(Car entity ,int id) {
		
		var tempCar = cars.get(id);
		tempCar.setBrandId(entity.getBrandId());
		tempCar.setColorId(entity.getColorId());
		tempCar.setDailyPrice(entity.getDailyPrice());
		tempCar.setYear(entity.getYear());
		tempCar.setDescription(entity.getDescription());
		
		
		cars.set(id, tempCar);
		return new SuccessResult("Araba bilgisi güncellendi.");
	}

	@Override
	public Result delete(Car entity) {
		cars.remove(entity);
		return new SuccessResult("Araç bilgisi silindi");
	}

	@Override
	public DataResult<Car> getById(int id) {
		
		return new SuccessDataResult<Car>(cars.get(id), "İlgili araç bilgisi getirildi.");
	}

	@Override
	public DataResult<List<Car>> getAll() {
		return new SuccessDataResult<List<Car>>(cars, "Araç bilgileri getirildi.");
	}
	
	
	
	
	
	

}
