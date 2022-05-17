package com.mgWorks.springBoot.JPA.Repository.test;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mgWorks.springBoot.JPA.Repository.StudentRepository;
import com.mgWorks.springBoot.JPA.entity.Gaurdian;
import com.mgWorks.springBoot.JPA.entity.Student;

@SpringBootTest
//@DataJpaTest                   //can used to test without affecting database
class StudentRepositoryTest {
	@Autowired
	private StudentRepository studentRepository;
	
//	@Test
	public void SaveStudent() {
		Student student = Student.builder()
				.emailId("mg123@mail.com")
				.firstName("mahi")
//				.gaurdianEmail(null)
//				.gaurdianMobile("8899667755")
//				.gaurdianName("lkn")
				.lastName("goud")
				.build();
		studentRepository.save(student);
		}
//	@Test
	public void saveStudentWithgaurdian() {
		Gaurdian gaurdian = Gaurdian.builder()
				.email("jaya@mail.com")
				.mobile("5566445522")
				.name("jaya")
				.build();	
		Student student = Student.builder()
				.emailId("mg123@mail.com")
				.firstName("mahindra")
				.gaurdian(gaurdian)
				.lastName("goud")
				.build();
		studentRepository.save(student);
		}
	
	@Test
	public void printAll() {
		List<Student> studentList = studentRepository.findAll();
		System.out.println("studentList :- "+studentList);
	}
	
	@Test
	public void printStudentByFirstName() {
		List<Student> students = studentRepository.findByFirstName("mahindra");
		System.out.println("StudentsListedByTheirFirstnames :- "+students);
	}
	@Test
	public void printStudentByfirstNameContaining() {
		List<Student> studentsContaining = studentRepository.findByFirstNameContaining("hind");
		System.out.println("StudentsListedByTheirFirstnamesContaining :- "+studentsContaining);
	}
	@Test
	public void printStudentByGaurdianname() {
		List<Student> studentsGaurdian = studentRepository.findByGaurdianName("jaya");
		System.out.println("StudentsListedByTheirGaurdianName :- "+studentsGaurdian);

	}
	@Test
	public void printStudentByFirstNameAndLastName() {
		List<Student> studentlist = studentRepository.findByFirstNameAndLastName("mahindra", "goud");
		System.out.println("printingStudentsByFirstNameAndLastName :- "+studentlist);
	}
	@Test
	public void printStudentsByLastNameNotNull() {
		List<Student> studlist = studentRepository.findByLastNameNotNull();
		System.out.println("printingStudentsByLastNameNotNull :- "+studlist);
	}
	@Test
	public void printStudentByEmailAddress() {
		Student studlist = studentRepository.getStudentByEmailAddress("mg123@mail.com");
		System.out.println("getStudentByEmailAddress :- "+studlist);
	}
	@Test
	public void printStudentFirstnameByEmailAddress() {
		System.out.println(studentRepository.getStudentFirstnameByEmailAddress("mg123@mail.com"));
	}
	@Test
	public void printStudentByEmailAddressNative() {
		System.out.println(studentRepository.getStudentByEmailAddressNative("mg123@mail.com"));
	}
	@Test
	public void printgetStudentByEmailAddressNativeNamedParam() {
		System.out.println(studentRepository.getStudentByEmailAddressNativeNamedParam("mg123@mail.com",
				                                                                       "5566445522"));
	}
	
	
	
}
