package com.springboot.web.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springboot.web.entity.Course;
import com.springboot.web.repo.CourseRepository;
@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepository courseRepo;
	
	@Override
//	public ResponseEntity<Course> upsert(Course course) {
//		Course save = courseRepo.save(course);
//		
//	   return ResponseEntity.ok(save);       //upsert (insert and Update Based On PK)	
//	}
	
	public ResponseEntity<Course> upsert(Course course) {
        Course savedCourse = courseRepo.save(course);
        return ResponseEntity.ok(savedCourse);
    }


	@Override
	public Course getById(Integer cid) {
		Optional<Course> findById = courseRepo.findById(cid);
		
		if(findById.isPresent()) {
			return findById.get();
		}
		
		return null;
	}

	@Override
	public List<Course> getAllCourses() {
		
		return courseRepo.findAll();
	}

	@Override
	public String deleteById(Integer cid) {
		if(courseRepo.existsById(cid)) {
			courseRepo.deleteById(cid);
			return "Delete Success";
		}
		else {
			return "no Record found";
		}
	}

	
}
