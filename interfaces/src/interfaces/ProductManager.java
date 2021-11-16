package interfaces;

import java.lang.System.Logger;
import java.util.ArrayList;
import java.util.List;

public class ProductManager implements ProductService {
	
	private ProductDao productDao;
	private LoggerService[] loggerService;
	

	




	public ProductManager(ProductDao productDao, LoggerService[] loggerService) {
		this.productDao = productDao;
		this.loggerService = loggerService;
	}
	

	@Override
	public void save(Product product) {
		productDao.save(product);
		Utility.RunLogger(loggerService);
		
		
		
	}

	@Override
	public ArrayList<Customer> list() {
		// TODO Auto-generated method stub
		return null;
	}

}
