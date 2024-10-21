package com.example.restpractice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restpractice.entity.Student;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	private List<Student> theStudents;
	
	// define @PostConstruct to load the student data ... only once
	
	@PostConstruct
	public void loadData() {
		theStudents = new ArrayList<>();
		
		theStudents.add(new Student("Rahul", "Pal"));
		theStudents.add(new Student("Ayushman", "Mohanty"));
		theStudents.add(new Student("Pratyush", "Sharma"));
	}

	// define endpoint for "/students" - return a list of students
	
	@GetMapping("/students")
	public List<Student> getStudents(){
		
		
		return theStudents;
	}
	
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		
		// just index into the list
		
		
		// check the studentId against list size
		
		if((studentId>= theStudents.size()) || (studentId<0)) {
			throw new StudentNotFoundException("Student id not found- "+studentId);
			
		}
		
		return theStudents.get(studentId);
	}
	

	
	
	
	
}
