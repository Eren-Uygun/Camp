package interfaces;

import java.util.List;

public class JpaProductDao implements ProductDao {

	@Override
	public void save(Product product) {
		System.out.println("Jpa");
		
	}

	@Override
	public List<Product> toList() {
		// TODO Auto-generated method stub
		return null;
	}

}
