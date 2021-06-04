package project.hrms.entities.dtos;

import java.util.List;

import project.hrms.entities.concretes.ExperienceForCV;
import project.hrms.entities.concretes.ForeignLanguageForCV;
import project.hrms.entities.concretes.ImageForCV;
import project.hrms.entities.concretes.JobSeeker;
import project.hrms.entities.concretes.LinkForCV;
import project.hrms.entities.concretes.ProgrammingSkillForCV;
import project.hrms.entities.concretes.SchoolForCV;

public class JobSeekerCVDto {

	public JobSeeker jobSeeker;
	public List<SchoolForCV> schools;
	public List<ProgrammingSkillForCV> programingSkills;
	public List<LinkForCV> links;
	public List<ForeignLanguageForCV> languages;
	public List<ExperienceForCV> experiences;
	public ImageForCV image;
}
