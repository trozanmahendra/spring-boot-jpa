package com.mgWorks.springBoot.JPA.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Teacher {
	@Id
	@SequenceGenerator(allocationSize = 1, initialValue = 9, sequenceName = "teacher_sequence", name = "teacher_sequence")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teacher_sequence")
	private Long teacherId;
	private String firstName;
	private String lastName;
	
//	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//	@JoinColumn(name = "teacher_id",referencedColumnName = "teacherId")
//	private List<Course> courses;

}
