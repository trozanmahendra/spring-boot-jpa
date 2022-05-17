package com.mgWorks.springBoot.JPA.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "stud", uniqueConstraints = @UniqueConstraint(columnNames = {  "emailAddress" }))

public class Student {
	@Id
	@SequenceGenerator(name = "Student_sequence", sequenceName = "Student_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "Student_sequence  ")
	private long studentId;
	@Column(name = "firstName", nullable = false)
	private String firstName;
	@Column(nullable = false)
	private String Lastname;
	@Column(name = "emailAddress", nullable = false) 
	private String emailId;
	@Column(nullable = false)
	private String gaurdianName;
	private String gaurdianEmail;
	@Column(nullable = false)
	private String gaurdianMobile;
}
