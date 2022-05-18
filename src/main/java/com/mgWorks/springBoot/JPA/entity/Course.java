package com.mgWorks.springBoot.JPA.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Course {
	@Id
	@SequenceGenerator(allocationSize = 1, initialValue = 9, sequenceName = "couse_sequence", name = "couse_sequence")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "couse_sequence")
	private Long courseId;
	private String title;
	private Integer credit;

	@OneToOne(mappedBy = "course")
	private CourseMaterial coursematerial;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "teacher_id", referencedColumnName = "teacherId")
	private Teacher teacher;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "student_course_map", 
	joinColumns = @JoinColumn(name = "course_id", 
								referencedColumnName = "courseId"),
								inverseJoinColumns = @JoinColumn(name = "student_id",
								referencedColumnName = "studentId"))
	private List<Student> students;
	
	public void addStudents(Student student) {
		if(students == null)students = new ArrayList<>();
	}
}
