package project.hrms.business.abstracts;

import java.util.List;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.JobSeeker;
import project.hrms.entities.dtos.JobSeekerCVDto;

public interface JobSeekerService {
	Result add(JobSeeker jobseeker);
	Result update(JobSeeker jobseeker);
	Result delete(int id);
	DataResult<JobSeeker> getById(int id);
	
	DataResult<List<JobSeeker>> getAll();
	DataResult<JobSeeker> getJobSeekerByNationalId(String nationalId);
	DataResult<JobSeekerCVDto> getJobSeekerCVById(int id);
}
