package interfaces;

import java.util.List;

public class JdbcProductDao implements ProductDao {

	@Override
	public void save(Product product) {
		// TODO Auto-generated method stub
		System.out.println("jdbc ile eklendi. " + product.getProductName());
		
	}

	@Override
	public List<Product> toList() {
		// TODO Auto-generated method stub
		return null;
	}

}
