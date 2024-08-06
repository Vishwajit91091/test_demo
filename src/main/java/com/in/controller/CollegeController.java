package com.in.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in.bean.College;
import com.in.repository.CollegeRepository;

@RestController
@RequestMapping("/college")
public class CollegeController {

	@Autowired
	CollegeRepository collegeRepository;
	
	@PostMapping("/save")
	public String saveCollege(@RequestBody College college) {	
	  collegeRepository.save(college);
		return "Created succfully";
	}
	
	@GetMapping("/get")
	public ResponseEntity< List<College>> getCollege(){
		List<College> collegeList=new ArrayList<College>();
		collegeRepository.findAll().forEach(collegeList::add);
		return new ResponseEntity<List<College>>(collegeList,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteCollegeById(@PathVariable("id") long id) {
		collegeRepository.deleteById(id);
		return "College Record With "+id+" Delete Succeffuly";
		
	}
	@PutMapping("/put/{id}")
	public String updateCollegeById(@PathVariable long id, @RequestBody College college) {
		Optional <College> cfgOptional= collegeRepository.findById(id);
	if(cfgOptional.isPresent()) {
		College cfg=cfgOptional.get();
		college.setCollegeId(id);
		collegeRepository.save(college);
		return "Update sussfully";
	}
	else {
		return "Recourd Not Found";
	}
		
		
	}
	
	
	
	
	
}
