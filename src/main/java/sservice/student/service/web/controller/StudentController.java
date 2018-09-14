package sservice.student.service.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import sservice.student.service.service.StudentService;
import sservice.student.service.model.Student;

@RestController
@RequestMapping(value="api/students")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Student>> getAllStudents(){
		List<Student> students = studentService.findAll();
		
		return new ResponseEntity<>(students, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Student> getStudent(@PathVariable Long id){
		Student student = studentService.findOne(id);
		if(student == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(student, HttpStatus.OK);
	}
	
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<Student> saveStudent(@RequestBody Student student){

		
		student = studentService.save(student);
		
		return new ResponseEntity<>(student, HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<Student> updateStudent(@RequestBody Student s){
		Student student = studentService.findOne(s.getId()); 
		if (student == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	
		student = studentService.save(student);
		return new ResponseEntity<>(student, HttpStatus.OK);	
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteStudent(@PathVariable Long id){
		Student student = studentService.findOne(id);
		if (student != null){
			studentService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {		
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
}
