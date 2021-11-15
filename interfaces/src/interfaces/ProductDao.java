package interfaces;

import java.util.List;

public interface ProductDao {
	
	void save(Product product);
	
	List<Product> toList();

}
