package com.mgWorks.springBoot.JPA.Repository.test;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mgWorks.springBoot.JPA.Repository.TeacherRepository;
import com.mgWorks.springBoot.JPA.entity.Course;
import com.mgWorks.springBoot.JPA.entity.Teacher;

@SpringBootTest
public class TeacherRepositorytest {
	@Autowired
	private TeacherRepository teacherRepository;
	@Test
	public void saveTeacher() {
//		Course coursePy = Course.builder().title("Python").credit(6).build();
//		Course courseDS = Course.builder().title("DAS").credit(16).build();
		Teacher teacher = Teacher.builder().firstName("Sundharam").lastName("Aradhulya")
//				.courses(List.of(courseDS,coursePy))
				.build();
		teacherRepository.save(teacher);
	}
}
