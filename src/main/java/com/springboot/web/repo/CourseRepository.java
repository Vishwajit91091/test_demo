package com.springboot.web.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.web.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

}
