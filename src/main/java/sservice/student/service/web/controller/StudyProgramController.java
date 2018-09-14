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

import sservice.student.service.service.StudyProgramService;
import sservice.student.service.model.StudyProgram;

@RestController
@RequestMapping(value = "api/studyPrograms")
public class StudyProgramController {
	
	@Autowired
	private StudyProgramService studyProgramService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<StudyProgram>> getAllStudijskiProgrami(){
		List<StudyProgram> studyPrograms = studyProgramService.findAll();
		
		return new ResponseEntity<>(studyPrograms, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<StudyProgram> getStudyProgram(@PathVariable Long id){
		StudyProgram studyProgram = studyProgramService.findOne(id);
		if(studyProgram == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(studyProgram, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<StudyProgram> saveStudyProgram(@RequestBody StudyProgram studyProgram){
		studyProgram = studyProgramService.save(studyProgram);
		
		return new ResponseEntity<>(studyProgram, HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<StudyProgram> updateStudyProgram(@RequestBody StudyProgram s){
		StudyProgram studyProgram = studyProgramService.findOne(s.getId()); 
		if (studyProgram == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	
		studyProgram = studyProgramService.save(studyProgram);
		return new ResponseEntity<>(studyProgram, HttpStatus.OK);	
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteStudyProgram(@PathVariable Long id){
		StudyProgram studyProgram = studyProgramService.findOne(id);
		if (studyProgram != null){
			studyProgramService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {		
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
} 

}
