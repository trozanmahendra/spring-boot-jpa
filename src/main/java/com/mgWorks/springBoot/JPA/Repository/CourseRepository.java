package com.mgWorks.springBoot.JPA.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mgWorks.springBoot.JPA.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
	Page<Course> findByTitleContaining(String title, Pageable pagable);
}
