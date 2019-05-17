package com.example.demo.rest.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class ProfessorController {
	
	@GetMapping("professor")
	public ResponseEntity<?> getAllProfessor(){
		return ResponseEntity.status(HttpStatus.OK).body("ok");
	}
	

}
