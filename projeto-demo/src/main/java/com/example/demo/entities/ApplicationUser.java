package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.example.demo.persistence.AbstractEntity;

@Entity
@Table(name = "application_user")
public class ApplicationUser extends AbstractEntity {
	
	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message ="The field username cannot be empty")
	@Column(unique = true)
	private String userName;
	
	@NotEmpty(message ="The field password cannot be empty")
	private String password;
	
	@OneToOne
	private Professor professor;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	

}
