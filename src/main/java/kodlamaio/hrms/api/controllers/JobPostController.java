package kodlamaio.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobPostService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;

import kodlamaio.hrms.entities.dtos.JobPostingAddDto;
import kodlamaio.hrms.entities.dtos.JobPostingDto;

@RestController
@RequestMapping("api/jobPostings")
public class JobPostController {
	
	private JobPostService jobPostService;

	@Autowired
	public JobPostController(JobPostService jobPostService) {
		super();
		this.jobPostService = jobPostService;
	}


	@GetMapping("/getActive")
	DataResult<List<JobPostingDto>> findByIsActive(){
		return this.jobPostService.findByIsActive();
	}
	
	
	@PostMapping("/add")
	Result add(@Valid @RequestBody JobPostingAddDto jobPostingAddDto) {
		return this.jobPostService.add(jobPostingAddDto);
	}
	
	
	
	@GetMapping("/getActive/OrderByEndDate")
	DataResult<List<JobPostingDto>> findByIsActiveOrderByClosedDate(){
		return this.jobPostService.findByIsActiveOrderByClosedDate();
	}
	
	@GetMapping("/get/CompanyName")
	DataResult<List<JobPostingDto>> findByIsActiveAndEmployer_CompanyName(String companyName){
		return this.jobPostService.findByIsActiveAndEmployer_CompanyName(companyName);
		
	}

}
