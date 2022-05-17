package com.mgWorks.springBoot.JPA.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mgWorks.springBoot.JPA.entity.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	public List<Student> findByFirstName(String firstName);
	public List<Student> findByFirstNameContaining(String name);
	public List<Student> findByLastNameNotNull();
	public List<Student> findByGaurdianName(String gaurdianName);
	
//	refernce documents to create different methods here below
//	https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods.query-creation

}
