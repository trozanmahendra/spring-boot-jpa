package com.mgWorks.springBoot.JPA.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mgWorks.springBoot.JPA.entity.Teacher;
@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

}
