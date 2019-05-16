package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.example.demo.persistence.AbstractEntity;

@Entity
@Table(name ="professor")
public class Professor extends AbstractEntity {

	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message ="the field name cannott be empty")
	private String name;
	
	@NotEmpty(message ="the field email cannott be empty")
	@Email(message ="this email is not valid")
	@Column(unique = true)
	private String email;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
