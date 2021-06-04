package project.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.hrms.business.abstracts.ExperienceForCVService;
import project.hrms.business.abstracts.ForeignLanguageForCVService;
import project.hrms.business.abstracts.ImageForCVService;
import project.hrms.business.abstracts.JobSeekerService;
import project.hrms.business.abstracts.LinkForCVService;
import project.hrms.business.abstracts.ProgrammingSkillForCVService;
import project.hrms.business.abstracts.SchoolForCVService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccessDataResult;
import project.hrms.core.utilities.results.SuccessResult;
import project.hrms.dataAccess.abstracts.JobSeekerDao;
import project.hrms.entities.concretes.JobSeeker;
import project.hrms.entities.dtos.JobSeekerCVDto;


@Service
public class JobSeekerManager implements JobSeekerService {

	private JobSeekerDao jobSeekerDao;
	private ExperienceForCVService experienceForCVService;
	private ForeignLanguageForCVService foreignLanguageForCVService;
	private ImageForCVService imageForCVService;
	private LinkForCVService linkForCVService;
	private ProgrammingSkillForCVService programmingSkillForCVService;
	private SchoolForCVService schoolForCVService;

	public JobSeekerManager(JobSeekerDao jobSeekerDao, ExperienceForCVService experienceForCVService,
			ForeignLanguageForCVService foreignLanguageForCVService, ImageForCVService imageForCVService,
			LinkForCVService linkForCVService, ProgrammingSkillForCVService programmingSkillForCVService,
			SchoolForCVService schoolForCVService) {
		super();
		this.jobSeekerDao = jobSeekerDao;
		this.experienceForCVService = experienceForCVService;
		this.foreignLanguageForCVService = foreignLanguageForCVService;
		this.imageForCVService = imageForCVService;
		this.linkForCVService = linkForCVService;
		this.programmingSkillForCVService = programmingSkillForCVService;
		this.schoolForCVService = schoolForCVService;
	}

	@Override
	public Result add(JobSeeker jobSeeker) {
		this.jobSeekerDao.save(jobSeeker);
		return new SuccessResult("JobSeeker has been added.");
	}

	@Override
	public Result update(JobSeeker jobSeeker) {
		this.jobSeekerDao.save(jobSeeker);
		return new SuccessResult("JobSeeker has been updated.");
	}

	@Override
	public Result delete(int id) {
		this.jobSeekerDao.deleteById(id);
		return new SuccessResult("JobSeeker has been deleted.");
	}

	@Override
	public DataResult<JobSeeker> getById(int id) {
		return new SuccessDataResult<JobSeeker>(this.jobSeekerDao.getById(id));
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll());
	}

	@Override
	public DataResult<JobSeeker> getJobSeekerByNationalId(String nationalId) {
		return new SuccessDataResult<JobSeeker>(this.jobSeekerDao.findJobSeekerByNationalId(nationalId));
	}

	@Override
	public DataResult<JobSeekerCVDto> getJobSeekerCVById(int id) {
		JobSeeker jobSeeker = this.jobSeekerDao.getById(id);
		JobSeekerCVDto cv = new JobSeekerCVDto();
		cv.experiences = jobSeeker.getExperiences();
		cv.languages = jobSeeker.getLanguages();
		cv.image = jobSeeker.getImage();
		cv.links = jobSeeker.getLinks();
		cv.programingSkills = jobSeeker.getProgramingSkills();
		cv.schools = jobSeeker.getSchools();
		return new SuccessDataResult<JobSeekerCVDto>(cv);
	}

}
