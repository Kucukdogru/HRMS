package com.example.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hrms.business.abstracts.EducationService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Education;
import com.example.hrms.entities.dtos.EducationAddDto;
import com.example.hrms.entities.dtos.EducationDto;
import com.example.hrms.entities.dtos.JobPostingAddDto;

@RestController
@RequestMapping("/api/education")
@CrossOrigin
public class EducationsController {
	private EducationService educationService;

	@Autowired
	public EducationsController(EducationService educationService) {
		super();
		this.educationService = educationService;
	};
	
	@GetMapping("getall")
	public DataResult<List<Education>> getAll(){
		return this.educationService.getAll();
	}
	
	@PostMapping("add")
	public Result add(@Valid @RequestBody Education education) {
		return this.educationService.add(education);
	}
	
	@GetMapping("getallsorteddesc")
	public DataResult<List<Education>> getAllSortedDesc() {
		return this.educationService.getAllSortedDesc();
	}
	
	@GetMapping("geteducationwithdetails")
	public DataResult<List<EducationDto>> getEducationWithDetails() {
		return this.educationService.getEducationWithDetails();
	}
	
	@PostMapping("/addEducationDto")
	public Result addJobPosting(@Valid @RequestBody EducationAddDto educationDto) {		
		return this.educationService.addEducationDto(educationDto);
	}
}
