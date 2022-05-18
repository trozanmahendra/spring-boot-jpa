package com.mgWorks.springBoot.JPA.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@ToString(exclude = "course")
public class CourseMaterial {
	@Id
	@SequenceGenerator(allocationSize = 1, initialValue = 9, sequenceName = "CourseMaterial_sequence", name = "CourseMaterial_sequence")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CourseMaterial_sequence")
	private Long courseMaterialId;
	private String url;
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name = "course_id", referencedColumnName = "courseId")
	private Course course;

}
