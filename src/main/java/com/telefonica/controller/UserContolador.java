package com.telefonica.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.telefonica.entity.Student;
import com.telefonica.service.StudentService;

@RestController
@RequestMapping("/api/v1/student")
public class UserContolador {

	
	@Autowired 
	private StudentService studentService;
	
	
	@GetMapping
	public List<Student> getAll()
	{
		List<Student> list = new ArrayList<>();
		list = studentService.getStudents();
		return list;
	}
	
	@GetMapping("/{idStudent}")
	public List<Student> getById(@PathVariable("idStudent") Long idStudent) {
	    List<Student> list = new ArrayList<>();
	    Optional<Student> student = studentService.getStudent(idStudent);
	    student.ifPresent(list::add);
	    return list;
	}
	
	@PostMapping
	public  ResponseEntity<?> save(@RequestBody Student student)
	{
		try {
			List<Student> list = new ArrayList<>();
			studentService.saveStudent(student);
			list.add(student);
			return ResponseEntity.status(HttpStatus.OK).body(list);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creando el estudiante");
		}
	}
	
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Student student) {
        try {
        	List<Student> list = new ArrayList<>();
	        Optional<Student> student1 = studentService.getStudent(id);
	        if (!student1.isPresent()) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe estudiante con id '" + id +"' para actualizar");
	        }
	        student.setEid(id);
            studentService.updateStudent(student);
	        list.add(student);
            return ResponseEntity.status(HttpStatus.OK).body(list);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error actualizando el estudiante: " + e.getMessage());
        }
    }
	
	
	@DeleteMapping("/{idStudent}")
	public ResponseEntity<String> deleteById(@PathVariable("idStudent") Long idStudent) {
	    try {
	        Optional<Student> student = studentService.getStudent(idStudent);
	        
	        if (!student.isPresent()) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe estudiante con id: " + idStudent);
	        }
	        studentService.deleteStudent(idStudent);
	        return ResponseEntity.status(HttpStatus.OK).body("Estudiante eliminado");
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar el estudiante");
	    }
	}

}
