package com.in.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.in.bean.College;

@Repository
public interface CollegeRepository extends JpaRepository<College, Long> {
	
}
