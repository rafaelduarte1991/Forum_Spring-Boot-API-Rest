package com.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.forum.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{

	Course findByName(String course);	
	
}
