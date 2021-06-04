package project.hrms.business.abstracts;

import java.util.List;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.ExperienceForCV;

public interface ExperienceForCVService {
	Result add(ExperienceForCV experienceForCV);
	Result update(ExperienceForCV experienceForCV);
	Result delete(int id);
	DataResult<ExperienceForCV> getById(int id);	
	DataResult<List<ExperienceForCV>> getAll();
	DataResult<List<ExperienceForCV>> getAllByJobSeekerIdOrderByEndAtDesc(int id);
	DataResult<List<ExperienceForCV>> getAllByJobSeekerId(int id);
}
