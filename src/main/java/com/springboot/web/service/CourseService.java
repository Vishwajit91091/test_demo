package com.springboot.web.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.springboot.web.entity.Course;

public interface CourseService {

	public ResponseEntity<Course> upsert(Course course);
	
	public Course getById(Integer cid);
	
	public List<Course> getAllCourses();
	
	public String deleteById(Integer cid);
	
}
