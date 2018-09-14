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

import sservice.student.service.dto.SubjectDTO;
import sservice.student.service.model.StudyProgram;
import sservice.student.service.model.Subject;
import sservice.student.service.service.StudyProgramService;
import sservice.student.service.service.SubjectService;

@RestController
@RequestMapping(value = "api/subjects")
public class SubjectController {

	@Autowired
	private SubjectService subjectService;
	
	
	@Autowired
	private StudyProgramService studyProgramService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Subject>> getAllSubjects() {
		List<Subject> subjects = subjectService.findAll();
		
		return new ResponseEntity<>(subjects, HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Subject> getSubject(@PathVariable Long id){
		Subject subject = subjectService.findOne(id);
		if(subject == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(subject, HttpStatus.OK);
	}
	
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<SubjectDTO> saveSubject(@RequestBody SubjectDTO subjectDTO){

		StudyProgram studyProgram = studyProgramService.findOne(subjectDTO.getStudyProgram().getId());
		Subject subject = new Subject();
		subject.setName(subjectDTO.getName());
		subject.setLabel(subjectDTO.getLabel());
		subject.setEcts(subjectDTO.getEcts());
		subject.setStudyProgram(studyProgram);
		
		subject = subjectService.save(subject);
		
		return new ResponseEntity<>(new SubjectDTO(subject), HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<Subject> updateSubject(@RequestBody Subject s){
		Subject subject = subjectService.findOne(s.getId()); 
		if (subject == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	
		subject = subjectService.save(subject);
		return new ResponseEntity<>(subject, HttpStatus.OK);	
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteSubject(@PathVariable Long id){
		Subject subject = subjectService.findOne(id); 
		if (subject != null){
			subjectService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {		
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
}
	
	
}
