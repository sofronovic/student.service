package sservice.student.service.service;

import org.springframework.beans.factory.annotation.Autowired;

import sservice.student.service.repository.StudentRepository;

public class StudentService {
	
	@Autowired
	StudentRepository studentRepository;

}
