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

import sservice.student.service.dto.TeacherTypeDTO;
import sservice.student.service.model.*;
import sservice.student.service.service.TeacherTypeService;


@RestController
@RequestMapping(value = "api/teacherTypes")
public class TeacherTypeController {

	@Autowired
	private TeacherTypeService teacherTypeService;
	
	@RequestMapping(value="/all", method = RequestMethod.GET)
	public ResponseEntity<List<TeacherType>> getAllTeacherTypes(){
		List<TeacherType> teachersType = teacherTypeService.findAll();
		
		return new ResponseEntity<>(teachersType, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<TeacherType>> getTeacherTypesPage(Pageable page){
		Page<TeacherType> pageTeacherTypes = teacherTypeService.findAll(page);
		List<TeacherType> teacherTypes = new ArrayList<>();
		for(TeacherType s : pageTeacherTypes){
			teacherTypes.add(s);
		}
		return new ResponseEntity<>(teacherTypes, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<TeacherType> getTeacherType(@PathVariable Long id){
		TeacherType teacherType = teacherTypeService.findOne(id);
		if(teacherType == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(teacherType, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<TeacherTypeDTO> saveTeacherType(@RequestBody TeacherTypeDTO teacherTypeDTO){
		TeacherType t = new TeacherType();
		t.setName(teacherTypeDTO.getName());
		t = teacherTypeService.save(t);
		System.out.println("TEACHER TYPE" + t.getName());
		
		return new ResponseEntity<>(new TeacherTypeDTO(t), HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<TeacherType> updateTeacherType(@RequestBody TeacherType t){
		TeacherType teacherType = teacherTypeService.findOne(t.getId()); 
		if (teacherType == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	
		teacherType = teacherTypeService.save(teacherType);
		return new ResponseEntity<>(teacherType, HttpStatus.OK);	
	}
	

	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteTeacherType(@PathVariable Long id){
		TeacherType teacherType = teacherTypeService.findOne(id);
		if (teacherType != null){
			teacherTypeService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {		
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
} 
	
}
