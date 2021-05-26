package project.hrms.business.abstracts;

import java.util.List;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.Employee;

public interface EmployeeService {
	//Result add(Employee employee);
	//Result update(Employee employee);
	//Result delete(int id);
	//DataResult<Employee> getById(int id);
	
	DataResult<List<Employee>> getAll();
	
}
