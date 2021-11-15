package interfaces;

import java.util.ArrayList;
import java.util.List;

public class ProductManager implements ProductService {
	
	private ProductDao productDao;
	private LoggerService loggerService;
	
	
	
	public ProductManager(ProductDao productDao, LoggerService loggerService) {
		this.productDao = productDao;
		this.loggerService = loggerService;
	}

	@Override
	public void save(Product product) {
		productDao.save(product);
		loggerService.log();
		
		
		
	}

	@Override
	public ArrayList<Customer> list() {
		// TODO Auto-generated method stub
		return null;
	}

}
