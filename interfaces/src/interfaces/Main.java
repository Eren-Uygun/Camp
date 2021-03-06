package interfaces;


public class Main {

	/*
	 * Bu Yapı en kötü interface kullanım şeklidir.
	CustomerService customerService = new CustomerService() {
		
		@Override
		public void save(Customer customer) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public ArrayList<Customer> list() {
			// TODO Auto-generated method stub
			return null;
		}
	};
	*/
	//Interface -> 
	public static void main(String[] args) {
		
	
		//JdbcCustomerDao jdbcCustomerDao = new JdbcCustomerDao();
		//jdbcCustomerDao.save(null);
		
		//interface'ler referans tutucudur.Onu implemente eden sınıfların referansını tutabilir.
		
		//CustomerDao customerDao = new JpaCustomerDao();
		//CustomerDao customerDao = new JdbcCustomerDao();
		//Interface onu implement eden sınıf ile new'lenir ise onun içeriğini kullanır.
		
		//CustomerManager customerManager = new CustomerManager(new JpaCustomerDao());
		//customerManager.save(null);
		
		Product product = new Product();
		product.setId(1);
		product.setProductName("Laptop");
		product.setQuantity(5);
		product.setUnitPrice(12);
		
		
		//ProductService productService = new ProductManager(new JdbcProductDao(),new FileLoggerManager());
		//ProductService productService1 = new ProductManager(new JdbcProductDao(),new DbLoggerManager());
		
		
		LoggerService[] loggerServices = {
				new FileLoggerManager(), new DbLoggerManager(),new Slf4jLoggerManager()
		};
		
		
		//ProductService productService = new ProductManager(loggerServices);
		//Kullanım Doğru
		ProductService productService1 = new ProductManager(new JdbcProductDao(),loggerServices);
		//productService.save(product);
		productService1.save(product);
	    //productService.save(product);
		
		
	//Polymorphism => Çok biçimlilik
		
		

	}

}
