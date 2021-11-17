package northwind.business.concretes;

import java.util.List;

import northwind.business.abstracts.EmployeeService;
import northwind.core.utilities.results.DataResult;
import northwind.core.utilities.results.Result;
import northwind.dataAccess.abstracts.EmployeeRepository;
import northwind.entities.concretes.Employee;

public class EmployeeManager implements EmployeeService {
	
	private EmployeeRepository employeeRepository;
	
	

	public EmployeeManager(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Result add(Employee employee) {
		// TODO Auto-generated method stub
	 return	this.employeeRepository.add(employee);
		
	}

	@Override
	public DataResult<List<Employee>> getAll() {
		// TODO Auto-generated method stub
		return this.employeeRepository.getAll();
	}

}
