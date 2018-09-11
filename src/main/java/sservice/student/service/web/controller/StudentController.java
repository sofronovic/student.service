package sservice.student.service.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sservice.student.service.service.StudentService;

@RestController
@RequestMapping(value="api/students")
public class StudentController {

	@Autowired
	private StudentService studentService;
}
