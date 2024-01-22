package com.example.demo.service;

import java.util.List;
import java.util.Optional; 

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;



@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	public Student createStudent(Student student) {
		return  studentRepository.save(student);
	}

	public List<Student> getAll() {
		return  studentRepository.findAll();
		}
	
	public Optional findByStudentId(long studentId){
		return studentRepository.findById(studentId);
		}
	
	public void delete(Student student){
		studentRepository.delete(student);
		}
	
	public Student save(Student student) {
		// TODO Auto-generated method stub
		return studentRepository.save(student);
		}
}
