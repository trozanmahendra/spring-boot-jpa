package com.mgWorks.springBoot.JPA.Repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mgWorks.springBoot.JPA.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	public List<Student> findByFirstName(String firstName);

	public List<Student> findByFirstNameContaining(String name);

	public List<Student> findByLastNameNotNull();

	public List<Student> findByGaurdianName(String gaurdianName);

	public List<Student> findByFirstNameAndLastName(String firstName, String lastName);
//	JPQL
	@Query("select stud from Student stud where stud.emailId=?1")
	public Student getStudentByEmailAddress(String emailId);
//	JPQL
	@Query("select stud.firstName from Student stud where stud.emailId=?1")
	public String getStudentFirstnameByEmailAddress(String emailId);
	
//	Native
	@Query(value = "select * from stud s where s.email_address = ?1", nativeQuery = true)
	public Student getStudentByEmailAddressNative(String emailId);
	
//	Native named params
	@Query(value = "select * from stud s where s.email_address=:emailId and s.gaurdian_mobile=:mobile", nativeQuery = true)
	public Student getStudentByEmailAddressNativeNamedParam(@Param("emailId") String emailId,
			@Param("mobile") String mobile);
	@Modifying
	@Transactional
	@Query(value = "update stud s set s.first_name=?1 where s.email_address=?2",nativeQuery = true)
	public int updateStudentNameByEmailId(String firstName , String emailId);

//	refernce documents to create different methods here below
//	https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods.query-creation

}
