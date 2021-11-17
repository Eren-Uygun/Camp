package business.abstracts;

import java.util.List;

import core.utilities.results.DataResult;
import core.utilities.results.Result;

public interface BaseService<T> {
	
	Result insert(T entity);
	Result update(T entity);
	Result delete(T entity);
	DataResult<T> getById(int id);
	DataResult<List<T>> getAll();

}
