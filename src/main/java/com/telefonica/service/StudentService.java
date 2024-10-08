package com.telefonica.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telefonica.entity.Student;
import com.telefonica.repository.StudentRepository;

@Service
public class StudentService 
{
	@Autowired
	StudentRepository studentRepository;
	
	public List<Student> getStudents(){
		return studentRepository.findAll();
	}
	
	public Optional<Student> getStudent(Long id){
		return studentRepository.findById(id);
	}
	
	public void saveStudent(Student student){
		studentRepository.save(student);
	}
	
	 public void updateStudent(Student student) {
		 studentRepository.save(student);
	 }
	
	public void deleteStudent(Long id){
		studentRepository.deleteById(id);
	}
}
