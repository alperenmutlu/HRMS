package project.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import project.hrms.business.abstracts.JobSeekerService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.JobSeeker;
import project.hrms.entities.dtos.JobSeekerCVDto;


@RestController
@RequestMapping("/api/jobseekers")
@CrossOrigin
public class JobSeekersController {

	private JobSeekerService jobSeekerService;

	@Autowired
	public JobSeekersController(JobSeekerService jobSeekerService) {
		super();
		this.jobSeekerService = jobSeekerService;
	}
		
	@PostMapping("/add")
	public Result add(@RequestBody JobSeeker jobseeker){
		return this.jobSeekerService.add(jobseeker);
	}
//	
//	@PostMapping("/update")
//	public Result update(@RequestBody JobSeeker jobSeeker){
//		return this.jobSeekerService.update(jobSeeker);
//	}
//	
//	@PostMapping("/delete")
//	public Result delete(@RequestParam("id") int id){
//		return this.jobSeekerService.delete(id);
//	}
//	
//	@GetMapping("/getbyid")
//	public DataResult<JobSeeker> getById(@RequestParam("id") int id){
//		return this.jobSeekerService.getById(id);
//	}
	
	@GetMapping("/getall")
	public DataResult<List<JobSeeker>> getAll(){
		return this.jobSeekerService.getAll();
	}
	
	@GetMapping("/getJobSeekerCVById")
	public DataResult<JobSeekerCVDto> getJobseekerCVById(@RequestParam int id){
		return this.jobSeekerService.getJobSeekerCVById(id);
	}
	
}