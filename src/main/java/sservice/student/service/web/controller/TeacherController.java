package sservice.student.service.web.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import sservice.student.service.dto.TeacherDTO;
import sservice.student.service.model.*;
import sservice.student.service.service.TeacherService;
import sservice.student.service.service.TeacherTypeService;

@RestController
@RequestMapping(value="api/teachers")
public class TeacherController {
	
	@Autowired
	private TeacherService teacherService;
	
	@Autowired
	private TeacherTypeService teacherTypeService;
	
	
	@RequestMapping(value="/all", method = RequestMethod.GET)
	public ResponseEntity<List<TeacherDTO>> getAllTeachers(){
		
		List<Teacher> teachers = teacherService.findAll();
		List<TeacherDTO> teacherDTOs = new ArrayList<>();
		for (Teacher teacher : teachers) {
			teacherDTOs.add(new TeacherDTO(teacher));
		}
		return new ResponseEntity<>(teacherDTOs, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Teacher>> getTeachersPage(Pageable page){
		Page<Teacher> pageTeachers = teacherService.findAll(page);
		List<Teacher> teachers = new ArrayList<>();
		for (Teacher p : pageTeachers) {
			teachers.add(p);
		}
		return new ResponseEntity<>(teachers, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<TeacherDTO> getTeacher(@PathVariable Long id){
		
		Teacher teacher = teacherService.findOne(id);
		if (teacher == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(new TeacherDTO(teacher), HttpStatus.OK);
	}
	
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<TeacherDTO> saveTeacher(@RequestBody TeacherDTO teacherDTO){
		
		if(teacherDTO.getTeacherType() == null){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		TeacherType teacherType = teacherTypeService.findOne(teacherDTO.getTeacherType().getId());
		if (teacherType == null){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Teacher teacher = new Teacher();
		teacher.setTeacherType(teacherType);
		
		teacher = teacherService.save(teacher);
		return new ResponseEntity<>(new TeacherDTO(teacher), HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<TeacherDTO> updateTeacher(@RequestBody TeacherDTO teacherDTO){
		
		Teacher teacher = teacherService.findOne(teacherDTO.getId());
		if (teacher == null){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	    teacher = teacherService.save(teacher);
	    return new ResponseEntity<>(new TeacherDTO(teacher), HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteTeacher(@PathVariable Long id){
		Teacher teacher = teacherService.findOne(id);
		if (teacher != null){
			teacherService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
