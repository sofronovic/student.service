package sservice.student.service.web.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import sservice.student.service.dto.ExamDTO;
import sservice.student.service.model.*;
import sservice.student.service.service.CourseAttendingService;
import sservice.student.service.service.ExamService;
import sservice.student.service.service.StudentService;
import sservice.student.service.service.SubjectService;
import sservice.student.service.service.TeacherService;

@RestController
@RequestMapping(value="api/exams")
public class ExamController {

	@Autowired
	private ExamService examService;
	
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private SubjectService subjectService;
	
	@Autowired
	private TeacherService teacherService;
	
	@RequestMapping(value="/all", method = RequestMethod.GET)
	public ResponseEntity<List<ExamDTO>> getAllExams(){
		
		List<Exam> exams = examService.findAll();
		List<ExamDTO> examsDTO = new ArrayList<>();
		for(Exam exam : exams){
			examsDTO.add(new ExamDTO(exam));
		}
		return new ResponseEntity<>(examsDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<ExamDTO> getExam(@PathVariable Long id){
		
		Exam exam = examService.findOne(id);
		if(exam == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(new ExamDTO(exam), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<ExamDTO> saveExam(@RequestBody  ExamDTO examDTO){
		
		if(examDTO.getStudent() == null 
				|| examDTO.getSubject() == null 
				|| examDTO.getTeacher() == null){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Student student = studentService.findOne(examDTO.getStudent().getId());
		Subject subject = subjectService.findOne(examDTO.getSubject().getId());
		Teacher teacher = teacherService.findOne(examDTO.getTeacher().getId());
		
		if (student == null || teacher == null || subject == null){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Exam exam = new Exam();
		exam.setType(examDTO.getType());
		exam.setScore(examDTO.getScore());
		exam.setPoints(examDTO.getPoints());
		exam.setStudent(student);
		exam.setTeacher(teacher);
		exam.setSubject(subject);
		
		exam = examService.save(exam);
		return new ResponseEntity<>(new ExamDTO(exam), HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<ExamDTO> updateExam(@RequestBody ExamDTO examDTO){
		
		Exam exam = examService.findOne(examDTO.getId());
		if(exam == null){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		exam.setType(examDTO.getType());
		exam.setPoints(examDTO.getPoints());
		exam.setScore(examDTO.getScore());
		
		exam = examService.save(exam);
		return new ResponseEntity<>(new ExamDTO(exam), HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteExam(@PathVariable Long id){
		
		Exam exam = examService.findOne(id);
		
		if(exam !=null){
			examService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}else{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
}
