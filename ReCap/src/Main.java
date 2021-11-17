import business.abstracts.BrandService;
import business.abstracts.CarService;
import business.concretes.BrandManager;
import business.concretes.CarManager;
import core.utilities.results.DataResult;
import dataAccess.concretes.BrandDao;
import dataAccess.concretes.CarDao;
import entities.Brand;
import entities.Car;
import entities.Color;

public class Main {

	public static void main(String[] args) {
		
		Car car = new Car();
		car.setCarId(1);
		car.setBrandId(1);
		car.setColorId(1);
		car.setDailyPrice(50);
		car.setDescription("Yeni model araba");
		car.setYear(2010);
		
		Brand brand = new Brand();
		brand.setBrandId(1);
		brand.setBrandName("Nissan");
		
		Color color = new Color();
		color.setColorId(1);
		color.setColorName("Mavi");
		
		BrandService brandService = new BrandManager(new BrandDao());
		brandService.insert(brand);
		
		CarService carService = new CarManager(new CarDao());
		carService.insert(car);
		carService.getAll();
		
		
		//brandService.getAll();

	}

}
