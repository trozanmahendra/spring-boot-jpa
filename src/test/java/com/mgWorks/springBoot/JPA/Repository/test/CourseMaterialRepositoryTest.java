package com.mgWorks.springBoot.JPA.Repository.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mgWorks.springBoot.JPA.Repository.CourseMaterialRepository;
import com.mgWorks.springBoot.JPA.entity.Course;
import com.mgWorks.springBoot.JPA.entity.CourseMaterial;

@SpringBootTest
public class CourseMaterialRepositoryTest {
	@Autowired
	private CourseMaterialRepository courseMaterialRepository;
	@Test
	public void saveCoursematerial() {
		Course course = Course.builder().credit(123).title("Java").build();
		CourseMaterial courseMaterial=CourseMaterial.builder().url("www.mg.com").course(course).build();
		courseMaterialRepository.save(courseMaterial);
	}
	@Test
	public void printCourseMaterial() {
		System.out.println(courseMaterialRepository.findAll());;
	}
}
