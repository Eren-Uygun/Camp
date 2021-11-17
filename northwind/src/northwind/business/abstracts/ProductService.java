package northwind.business.abstracts;

import java.util.List;

import northwind.core.utilities.results.DataResult;
import northwind.core.utilities.results.Result;
import northwind.entities.concretes.Product;

public interface ProductService {
	
	List<Product> getAll();
	DataResult<List<Product>> getDtAll();
	Result add(Product product);
}
