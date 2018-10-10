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

import sservice.student.service.dto.CourseLectureDTO;
import sservice.student.service.model.*;
import sservice.student.service.service.CourseLectureService;
import sservice.student.service.service.SubjectService;
import sservice.student.service.service.TeacherService;

@RestController
@RequestMapping(value="api/courseLectures")
public class CourseLectureController {
	
	@Autowired
	private CourseLectureService courseLectureService;
	
	@Autowired
	private TeacherService teacherService;
	
	@Autowired
	private SubjectService subjectService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<CourseLectureDTO>> getAllCourseLectures(){
		List<CourseLecture> courseLectures = courseLectureService.findAll();
		List<CourseLectureDTO> courseLectureDTOs = new ArrayList<>();
		for (CourseLecture cs : courseLectures) {
			courseLectureDTOs.add(new CourseLectureDTO(cs));
		}
		return new ResponseEntity<>(courseLectureDTOs, HttpStatus.OK);
	}
	
	
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<CourseLectureDTO> getCourseLecture(@PathVariable Long id){
		CourseLecture courseLecture = courseLectureService.findOne(id);
		if (courseLecture == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(new CourseLectureDTO(courseLecture), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes="application/json")
	public ResponseEntity<CourseLectureDTO> saveCourseLecture(@RequestBody CourseLectureDTO courseLectureDTOO){
		
		if(courseLectureDTOO.getTeacher() == null){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		if(courseLectureDTOO.getSubject() == null)
		{
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Teacher teacher = teacherService.findOne(courseLectureDTOO.getTeacher().getId());
		if(teacher == null){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		
		Subject subject = subjectService.findOne(courseLectureDTOO.getSubject().getId());
		if(subject == null){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		};
		
		CourseLecture courseLecture = new CourseLecture();
		courseLecture.setTeacher(teacher);
		courseLecture.setSubject(subject);
		
		courseLecture = courseLectureService.save(courseLecture);
		return new ResponseEntity<>(new CourseLectureDTO(courseLecture), HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<CourseLectureDTO> updateCourseLecture(@RequestBody CourseLectureDTO courseLectureDTO){
		
		CourseLecture courseLecture = courseLectureService.findOne(courseLectureDTO.getId());
		if(courseLecture == null){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		courseLecture = courseLectureService.save(courseLecture);
		return new ResponseEntity<>(new CourseLectureDTO(courseLecture), HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteCourseLecture(@PathVariable Long id){
		CourseLecture courseLecture = courseLectureService.findOne(id);
		if (courseLecture != null){
			courseLectureService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}else{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
