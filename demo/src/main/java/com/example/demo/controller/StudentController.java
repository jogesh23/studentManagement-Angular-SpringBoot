package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Student;
import com.example.demo.service.StudentServiceImpl;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class StudentController {
	
	@Autowired
	private StudentServiceImpl studentService;
	
	@PostMapping("/students")
	public Student createStudent(@Valid @RequestBody Student student) {
	//displaying student object in console for confirmation
	System.out.println(student);
	return studentService.createStudent(student);

	}
	
	@GetMapping("/students")
	public List<Student> getAllStudents() {
	//storing return type of Student Entity
	return studentService.getAll();
	}
	
	@GetMapping("/students/{id}")
	public ResponseEntity getStudentById(@PathVariable(value = "id") Long studentId)
	throws Throwable {
		System.out.println("details");
	Student student = (Student) studentService.findByStudentId(studentId)
	.orElseThrow(() -> new ResourceNotFoundException("student not found for this id :: " + studentId));
	return ResponseEntity.ok().body(student);
	}
	
	@DeleteMapping("/students/{id}")
	public Map deleteStudent(@PathVariable(value = "id") Long studentId)
	throws Throwable {
	Student student = (Student) studentService.findByStudentId(studentId)
	.orElseThrow(() -> new ResourceNotFoundException("Student not found for this id :: " + studentId));
	studentService.delete(student);
	Map response = new HashMap<>();
	response.put("deleted", Boolean.TRUE);
	return response;

	}

	@PutMapping("/students/{id}")
	public ResponseEntity updateStudent(@PathVariable(value = "id") Long studentId,
	@Valid @RequestBody Student studentDetails) throws Throwable {
	Student student = (Student) studentService.findByStudentId(studentId)
	.orElseThrow(() -> new ResourceNotFoundException("Student not found for this id :: " + studentId));
	student.setFirstName(studentDetails.getFirstName());
	final Student updatedStudent = studentService.save(student);
	return ResponseEntity.ok(updatedStudent);

	}
	

}
