package northwind.business.abstracts;

import java.util.List;

import northwind.core.utilities.results.DataResult;
import northwind.core.utilities.results.Result;
import northwind.entities.concretes.Category;
import northwind.entities.concretes.Employee;

public interface EmployeeService {
	
	Result add(Employee employee);
	DataResult<List<Employee>> getAll();

}
