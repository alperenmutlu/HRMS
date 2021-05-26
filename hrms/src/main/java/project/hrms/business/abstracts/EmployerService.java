package project.hrms.business.abstracts;

import java.util.List;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.Employer;

public interface EmployerService {
	Result add(Employer employer);
	//Result update(Employer employer);
	//Result delete(int id);
	//DataResult<Employer> getById(int id);
	
	DataResult<List<Employer>> getAll();
}
