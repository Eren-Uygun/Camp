package interfaces;

import java.util.ArrayList;

public class JpaCustomerDao implements CustomerDao {

	@Override
	public void save(Customer customer) {
		// TODO Auto-generated method stub
		System.out.println("Jpa db saved");
		
	}

	@Override
	public ArrayList<Customer> list() {
		// TODO Auto-generated method stub
		return null;
	}

}
