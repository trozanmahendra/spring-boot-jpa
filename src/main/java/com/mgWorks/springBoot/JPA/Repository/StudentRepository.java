package com.mgWorks.springBoot.JPA.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mgWorks.springBoot.JPA.entity.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
