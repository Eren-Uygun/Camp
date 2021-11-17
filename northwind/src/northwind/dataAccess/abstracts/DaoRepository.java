package northwind.dataAccess.abstracts;

import java.util.List;

import northwind.core.utilities.results.DataResult;
import northwind.core.utilities.results.Result;

public interface DaoRepository<T> {
	
	Result add(T entity);
	Result update(T entity);
	Result delete(T entity);
	DataResult<T> getById(int id);
	DataResult<List<T>> getAll();
	

}
