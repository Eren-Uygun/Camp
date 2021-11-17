package reCapWorkshop;

import reCapWorkshop.business.abstracts.BrandService;
import reCapWorkshop.business.abstracts.CarService;
import reCapWorkshop.business.abstracts.ColorService;
import reCapWorkshop.business.concretes.BrandManager;
import reCapWorkshop.business.concretes.CarManager;
import reCapWorkshop.business.concretes.ColorManager;
import reCapWorkshop.dataAccess.concretes.JpaBrandDao;
import reCapWorkshop.dataAccess.concretes.JpaCarDao;
import reCapWorkshop.dataAccess.concretes.JpaColorDao;
import reCapWorkshop.entities.concretes.Brand;
import reCapWorkshop.entities.concretes.Car;
import reCapWorkshop.entities.concretes.Color;

public class Main {

	public static void main(String[] args) {
		
		Brand brand = new Brand(1,"Toyota");
		Brand brand1 = new Brand(2,"Opel");
		Brand brand2 = new Brand(3,"Audi");
		
		BrandService brandService = new BrandManager(new JpaBrandDao());
		brandService.add(brand);
		brandService.add(brand1);
		brandService.add(brand2);
		brandService.add(new Brand(4,"Mercedes"));
		brandService.add(new Brand(5,"Anadol"));
		
		
		Color color = new Color(1,"Kırmızı");
		Color color1 = new Color(2,"Yeşil");
		Color color2 = new Color(3,"Mor");
		
		ColorService colorService = new ColorManager(new JpaColorDao());
		colorService.add(color);
		colorService.add(color1);
		colorService.add(color2);
		colorService.add(new Color(4,"Turuncu"));
		colorService.add(new Color(5,"Gri"));
		
		color1.setColorName("Beyaz");
		
		colorService.update(color2, 2);
		
		CarService carService = new CarManager(new JpaCarDao());
		
		
		Car car = new Car(1,1,1,2001,10,"Yeni Kiralık araç 1");
		Car car1 = new Car(2,2,3,2015,10,"Yeni Kiralık araç 2");
		Car car2 = new Car(3,1,3,2010,10,"Yeni Kiralık araç 3");
		
		carService.add(car);
		carService.add(car1);
		carService.add(car2);
		carService.add(new Car(4,4,3,2021,500,"2021 Model Kiralık Araç 4"));
		carService.add(new Car(5,5,3,2020,300,"2020 Model Kiralık Araç 4"));
		
		car2.setColorId(5);
		car2.setDailyPrice(600);
		carService.update(car2, 2);
		
		
		
		//colorService.delete(color2); ++
		
		//System.out.println(colorService.getById(2).getData().getColorName());
		
		
		for (Color iterableColor : colorService.getAll().getData()) {
			
			System.out.println(iterableColor.getColorId()+ " " + iterableColor.getColorName());
			
		}
		
		System.out.println("*-----------------------------------------------------------------*");
		
		for (Brand iterableBrand : brandService.getAll().getData()) {
			System.out.println(iterableBrand.getBrandId()+ " " + iterableBrand.getBrandName());
		}
		
		System.out.println("*-----------------------------------------------------------------*");
		
		for (Car iterableCar : carService.getAll().getData()) {
			System.out.println(iterableCar.getCarId() + " " +iterableCar.getBrandId() + " " + iterableCar.getColorId()+ " "+ iterableCar.getYear() +" " + iterableCar.getDailyPrice() + " "+iterableCar.getDescription());
			
		}

	}
	
}
