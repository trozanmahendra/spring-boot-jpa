package com.mgWorks.springBoot.JPA.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@AttributeOverrides({ @AttributeOverride(name = "name", column = @Column(name = "gaurdian_name")),
					 @AttributeOverride(name = "mobile",column = @Column(name = "gaurdian_mobile")), 
				   	@AttributeOverride(name = "email",column = @Column(name = "gaurdian_email")) })
public class Gaurdian {
	@Column(nullable = false)
	private String name;
	private String email;
	@Column(nullable = false)
	private String mobile;
}
