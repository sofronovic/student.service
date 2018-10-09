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

import sservice.student.service.dto.CourseAttendingDTO;
import sservice.student.service.dto.CourseLectureDTO;
import sservice.student.service.model.*;
import sservice.student.service.service.CourseAttendingService;
import sservice.student.service.service.CourseLectureService;
import sservice.student.service.service.StudentService;
import sservice.student.service.service.SubjectService;
import sservice.student.service.service.TeacherService;

@RestController
@RequestMapping(value="api/courseAttendings")
public class CourseAttendingController {
	
	@Autowired
	private CourseAttendingService courseService;
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private SubjectService subjectService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<CourseAttendingDTO>> getAllCourseAttendings(){
		List<CourseAttending> courseAttendings = courseService.findAll();
		List<CourseAttendingDTO> courseDTOs = new ArrayList<>();
		for (CourseAttending cs : courseAttendings) {
			courseDTOs.add(new CourseAttendingDTO(cs));
		}
		return new ResponseEntity<>(courseDTOs, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<CourseAttendingDTO> getCourseLecture(@PathVariable Long id){
		CourseAttending courseAttending = courseService.findOne(id);
		if (courseAttending == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(new CourseAttendingDTO(courseAttending), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes="application/json")
	public ResponseEntity<CourseAttendingDTO> saveCourseLecture(@RequestBody CourseAttendingDTO courseDTO){
		
		if(courseDTO.getStudent() == null){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		if(courseDTO.getSubject() == null){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Student student = studentService.findOne(courseDTO.getStudent().getId());
		if(student == null){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Subject subject = subjectService.findOne(courseDTO.getSubject().getId());
		if(subject == null){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		CourseAttending courseAttending = new CourseAttending();
		courseAttending.setSubject(subject);
		courseAttending.setStudent(student);
		
		courseAttending = courseService.save(courseAttending);
		return new ResponseEntity<>(new CourseAttendingDTO(courseAttending), HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<CourseAttendingDTO> updateCourseLecture(@RequestBody CourseAttendingDTO courseDTO){
		
		CourseAttending course = courseService.findOne(courseDTO.getId());
		if(course == null){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		course = courseService.save(course);
		return new ResponseEntity<>(new CourseAttendingDTO(course), HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteCourseLecture(@PathVariable Long id){
		CourseAttending courseAttending = courseService.findOne(id);
		if (courseAttending != null){
			courseService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}else{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
