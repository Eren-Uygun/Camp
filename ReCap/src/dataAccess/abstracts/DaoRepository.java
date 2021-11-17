package dataAccess.abstracts;

import java.util.List;

import core.utilities.results.DataResult;
import core.utilities.results.Result;

public interface DaoRepository<T> {
	
	Result insert(T entity);
	Result update(T entity);
	Result delete(T entity);
	DataResult<T> getById(int id);
	DataResult<List<T>> getAll();
	

}
