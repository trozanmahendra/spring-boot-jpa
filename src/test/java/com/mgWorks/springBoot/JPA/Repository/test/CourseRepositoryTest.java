package com.mgWorks.springBoot.JPA.Repository.test;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.mgWorks.springBoot.JPA.Repository.CourseRepository;
import com.mgWorks.springBoot.JPA.entity.Course;
import com.mgWorks.springBoot.JPA.entity.Student;
import com.mgWorks.springBoot.JPA.entity.Teacher;

@SpringBootTest
public class CourseRepositoryTest {
	
	@Autowired
	private CourseRepository courseRepository;
	@Test
	public void printCourse() {
//		Course course = Course.builder().credit(123).title("Java").build();
		List<Course> courses = courseRepository.findAll();
		System.out.println("courses="+courses);
	}
	@Test
	public void saveCourseWithTeacher() {
		Teacher teacher = Teacher.builder().firstName("Nagoor").lastName("Babu").build();
		Course course = Course.builder().title("spring").credit(23).teacher(teacher).build();
		courseRepository.save(course);
	}
//	pagination and sorting
	@Test
	public void findAllPagination() {
		Pageable firstpagewith3Records = PageRequest.of(0, 3);
		Pageable secondpagewith2Records = PageRequest.of(1, 2);
		System.out.println();
		List<Course> courses3 = courseRepository.findAll(firstpagewith3Records).getContent();
		System.out.println("Courses with 3 records = "+courses3);
		System.out.println();
		System.out.println();
		List<Course> courses2 = courseRepository.findAll(secondpagewith2Records).getContent();
		System.out.println("courses with 2 records = "+courses2);
		
		long totalElements = courseRepository.findAll(firstpagewith3Records).getTotalElements();
		int totalPages = courseRepository.findAll(firstpagewith3Records).getTotalPages();
		
		System.out.println("Total pages = "+totalPages);
		System.out.println("Total Elements = "+totalElements);
	}
	@Test
	public void findAllSorting() {
		Pageable sortByTitle = PageRequest.of(0, 3,Sort.by("title"));
		Pageable sortByCreditDesc = PageRequest.of(0, 3, Sort.by("credit").descending());
		
		Pageable sortByTitleAndCreditDesc = PageRequest.of(0, 3,Sort.by("title").and(Sort.by("credit").descending()));
		
		List<Course> courseT = courseRepository.findAll(sortByTitle).getContent();
		List<Course> courseC = courseRepository.findAll(sortByCreditDesc).getContent();
		List<Course> courseTandC = courseRepository.findAll(sortByTitleAndCreditDesc).getContent();

		System.out.println("sortByTitle = "+courseT);
		System.out.println("sortByCreditDesc = "+courseC);
		System.out.println("sortByTitleAndCreditDesc = "+courseTandC);
	}
	@Test
	public void findByTitleContaining() {
		Pageable sortByTitle = PageRequest.of(0, 3,Sort.by("title"));
		List<Course> courses = courseRepository.findByTitleContaining("y", sortByTitle).getContent();
		System.out.println(courses);
	}
	@Test
	public void saveCourseWithStudentAndTeacher() {
		Teacher teacher = Teacher.builder()
				.firstName("Durga")
				.lastName("prasad")
				.build();
		Student student = Student.builder()
				.firstName("Mahendra").lastName("Goud").emailId("magg@mail.com")
				.build();
		Course course = Course.builder().title("Core_java").credit(100).teacher(teacher).students(List.of(student)).build();
		course.addStudents(student);
		courseRepository.save(course);
	}
}
