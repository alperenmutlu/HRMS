package project.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.hrms.business.abstracts.EmployerService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccessDataResult;
import project.hrms.core.utilities.results.SuccessResult;
import project.hrms.dataAccess.abstracts.EmployerDao;
import project.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}

	@Override
	public Result add(Employer employer) {
		this.employerDao.save(employer);
		return new SuccessResult("Employer has been added!");
	}

	//@Override
	//public Result update(Employer employer) {
	//	this.employerDao.save(employer);
	//	return new SuccessResult("Employer has been updated!");
	//}

	//@Override
	//public Result delete(int id) {
	//	this.employerDao.deleteById(id);
	//	return new SuccessResult("Employer has been deleted!");
	//}

	//@Override
	//public DataResult<Employer> getById(int id) {
	//	return new SuccessDataResult<Employer>(this.employerDao.getOne(id));
	//}

	@Override
	public DataResult<List<Employer>> getAll() {	
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll());
	}

}
