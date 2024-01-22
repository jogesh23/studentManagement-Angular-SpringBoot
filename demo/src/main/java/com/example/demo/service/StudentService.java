package com.example.demo.service;

import java.util.List;
import java.util.Optional; 

import com.example.demo.model.Student;


public interface StudentService {
	
	public Student createStudent(Student student);
	
	public List<Student> getAll();
	
	public Optional findByStudentId(long studentId);
	
	public void delete(Student student);
	
	public Student save(Student student);
	
}
