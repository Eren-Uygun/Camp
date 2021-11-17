package northwind.business.abstracts;

import java.util.List;

import northwind.core.utilities.results.DataResult;
import northwind.core.utilities.results.Result;
import northwind.entities.concretes.Category;

public interface CategoryService {
	
	Result add(Category category);
	DataResult<List<Category>> getAll();

}
