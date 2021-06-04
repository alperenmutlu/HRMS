package project.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import project.hrms.business.abstracts.ExperienceForCVService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.ExperienceForCV;

@RestController
@RequestMapping("/api/experiences")
public class ExperiencesController {
	
	private ExperienceForCVService experienceForCVService;

	@Autowired
	public ExperiencesController(ExperienceForCVService experienceForCVService) {
		super();
		this.experienceForCVService = experienceForCVService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody ExperienceForCV experienceForCV){
		return this.experienceForCVService.add(experienceForCV);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody ExperienceForCV experienceForCV){
		return this.experienceForCVService.update(experienceForCV);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam("id") int id){
		return this.experienceForCVService.delete(id);
	}
	
	@GetMapping("/getbyid")
	public DataResult<ExperienceForCV> getById(@RequestParam int id){
		return this.experienceForCVService.getById(id);
	}
	
	@GetMapping("/getall")
	public DataResult<List<ExperienceForCV>> getAll(){
		return this.experienceForCVService.getAll();
	}
	
	@GetMapping("/getAllByJobSeekerIdOrderByEndAtDesc")
	public DataResult<List<ExperienceForCV>> getAllByJobseekerIdOrderByEndAtDesc(@RequestParam("id") int id){
		return this.experienceForCVService.getAllByJobSeekerIdOrderByEndAtDesc(id);
	}
	
	@GetMapping("/getAllByJobSeekerId")
	public DataResult<List<ExperienceForCV>> getAllByJobSeekerId(@RequestParam int id){
		return this.experienceForCVService.getAllByJobSeekerId(id);
	}
}
