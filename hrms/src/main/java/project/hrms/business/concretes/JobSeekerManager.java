package project.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import project.hrms.business.abstracts.JobSeekerService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccessDataResult;
import project.hrms.core.utilities.results.SuccessResult;
import project.hrms.dataAccess.abstracts.JobSeekerDao;
import project.hrms.entities.concretes.JobSeeker;

public class JobSeekerManager implements JobSeekerService{

	private JobSeekerDao jobSeekerDao;
	
	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao) {
		super();
		this.jobSeekerDao = jobSeekerDao;
	}
	
	@Override
	public Result add(JobSeeker jobSeeker) {
		this.jobSeekerDao.save(jobSeeker);
		return new SuccessResult("JobSeeker has been added!");
	}

	//@Override
	//public Result update(JobSeeker jobSeeker) {
	//	this.jobSeekerDao.save(jobSeeker);
	//	return new SuccessResult("JobSeeker has been updated!");
	//}

	//@Override
	//public Result delete(int id) {
	//	this.jobSeekerDao.deleteById(id);
	//	return new SuccessResult("JobSeeker has been deleted");
	//}

	//@Override
	//public DataResult<JobSeeker> getById(int id) {
	//	return new SuccessDataResult<JobSeeker>(this.jobSeekerDao.getOne(id));
	//}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll(), "JobSeekers Listed");
	}

	@Override
	public DataResult<JobSeeker> getJobSeekerByNationalId(String nationalId) {
		return new SuccessDataResult<JobSeeker>(this.jobSeekerDao.findJobSeekerByNationalId(nationalId));
	}

}
