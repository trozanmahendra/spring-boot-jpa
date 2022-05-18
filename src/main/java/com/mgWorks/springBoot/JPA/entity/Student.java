package com.mgWorks.springBoot.JPA.entity;

import javax.persistence.Column;
import javax.persistence.Embedded;
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
@Table(name = "stud", uniqueConstraints = @UniqueConstraint(columnNames = { "emailAddress" }))

public class Student {
	@Embedded
	private Gaurdian gaurdian;

	@Id
	@SequenceGenerator(name = "Student_sequence", sequenceName = "Student_sequence", initialValue = 9, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Student_sequence")
	private long studentId;
	@Column(name = "firstName")
	private String firstName;
	@Column(nullable = false)
	private String lastName;
	@Column(name = "emailAddress")
	private String emailId;

}
