package northwind.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import northwind.core.utilities.results.DataResult;
import northwind.core.utilities.results.Result;
import northwind.core.utilities.results.SuccessDataResult;
import northwind.core.utilities.results.SuccessResult;
import northwind.dataAccess.abstracts.EmployeeRepository;
import northwind.entities.concretes.Employee;

public class EmployeeDao implements EmployeeRepository {

	
	List<Employee>  employees;
	
	public EmployeeDao() {
		employees = new ArrayList<Employee>();
	}
	
	
	@Override
	public Result add(Employee employee) {
		employees.add(employee);
		return new SuccessResult("Çalışan eklendi");
		
	}

	@Override
	public DataResult<List<Employee>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Employee>>(this.employees,"Çalışanlar Listelendi.");
	}


	@Override
	public Result update(Employee entity) {
		this.employees.set(entity.getId(), entity);
		return new SuccessResult("Çalışan eklendi");
		
		
	}


	@Override
	public Result delete(Employee entity) {
		// TODO Auto-generated method stub
		this.employees.remove(entity);
		return new SuccessResult("Çalışan eklendi");
		
		
	}


	@Override
	public DataResult<Employee> getById(int id) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<Employee>(this.employees.get(id),"Çalışan getirildi.");
	}

}
