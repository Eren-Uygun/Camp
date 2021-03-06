package interfaces;

import java.util.ArrayList;

//Bir class Interface'i kendine implement eder.
//Interface'ler referans tutucudur.
//implement edilen class'ın referansını tutabilir.

//Business bölümünde iş kuralları yazılır.
//örn Ad'ın 2 en az karakter olması , Tc nin 11 haneli olması gibi
public class CustomerManager implements CustomerService {
	//3 Katmanlı yapılarda Dao -> Business -> UI
	//3 Katmanlı yapılarda Dao <- Business <- UI
	
	private  CustomerDao customerDao;
	
	//Dependency Injection
	public CustomerManager(CustomerDao customerDao) {
		//Bu yapı constructor injection'dur.
		this.customerDao = customerDao;
		//this.customerDao = new JpaCustomerDao();
		
	}

	@Override
	public void save(Customer customer) {
		// TODO Auto-generated method stub
		
		//Bu yapı bağımlılık yaratıcı yapıdır.Kullanımı yanlıştır.
		//JdbcCustomerDao jdbcCustomerDao = new JdbcCustomerDao();
		//jdbcCustomerDao.save(customer);
		customerDao.save(customer);
		
	
		
	}

	@Override
	public ArrayList<Customer> list() {
		// TODO Auto-generated method stub
		return null;
	}

}
