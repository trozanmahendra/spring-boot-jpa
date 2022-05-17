package com.mgWorks.springBoot.JPA.Repository.test;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mgWorks.springBoot.JPA.Repository.StudentRepository;
import com.mgWorks.springBoot.JPA.entity.Student;

@SpringBootTest
//@DataJpaTest
class StudentRepositoryTest {
	@Autowired
	private StudentRepository studentRepository;
	@Test
	public void SaveStudent() {
		Student student = Student.builder()
				.emailId("mg@mail.com")
				.firstName("Mahendra")
				.gaurdianEmail(null)
				.gaurdianMobile("8899667755")
				.gaurdianName("lkn")
				.Lastname("goud")
				.build();
		studentRepository.save(student);
		}
	@Test
	public void printAll() {
		List<Student> studentList = studentRepository.findAll();
		System.out.println("studentList :- "+studentList);
	}
}
