package project.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.hrms.business.abstracts.JobSeekerService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.JobSeeker;


@RestController
@RequestMapping("/api/jobseekers")
public class JobSeekersController {

	private JobSeekerService jobSeekerService;

	@Autowired
	public JobSeekersController(JobSeekerService jobSeekerService) {
		super();
		this.jobSeekerService = jobSeekerService;
	}
		
	@PostMapping("/add")
	public Result add(@RequestBody JobSeeker jobSeeker){
		return this.jobSeekerService.add(jobSeeker);
	}
//	
//	@PostMapping("/update")
//	public Result update(@RequestBody Jobseeker jobseeker){
//		return this.jobseekerService.update(jobseeker);
//	}
//	
//	@PostMapping("/delete")
//	public Result delete(@PathVariable("id") int id){
//		return this.jobseekerService.delete(id);
//	}
//	
//	@GetMapping("/getbyid")
//	public DataResult<Jobseeker> getById(@PathVariable("id") int id){
//		return this.jobseekerService.getById(id);
//	}
	
	@GetMapping("/getall")
	public DataResult<List<JobSeeker>> getAll(){
		return this.jobSeekerService.getAll();
	}
	
}