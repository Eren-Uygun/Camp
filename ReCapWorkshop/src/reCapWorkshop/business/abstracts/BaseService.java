package reCapWorkshop.business.abstracts;

import java.util.List;

import reCapWorkshop.core.utilities.results.DataResult;
import reCapWorkshop.core.utilities.results.Result;

public interface BaseService<T> {
	
	Result add(T entity);
	Result update(T entity , int id);
	Result delete(T entity);
	DataResult<T> getById(int id);
	DataResult<List<T>> getAll();

}
