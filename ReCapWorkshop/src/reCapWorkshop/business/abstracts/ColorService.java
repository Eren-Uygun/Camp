package reCapWorkshop.business.abstracts;

import java.util.List;

import reCapWorkshop.core.utilities.results.DataResult;
import reCapWorkshop.core.utilities.results.Result;
import reCapWorkshop.entities.concretes.Car;
import reCapWorkshop.entities.concretes.Color;

public interface ColorService{
	
	Result add(Color entity);
	Result update(Color entity , int id);
	Result delete(Color entity);
	DataResult<Color> getById(int id);
	DataResult<List<Color>> getAll();

}
