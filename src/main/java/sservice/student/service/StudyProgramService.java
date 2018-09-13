package sservice.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import sservice.student.service.model.StudyProgram;
import sservice.student.service.repository.StudyProgramRepository;

@Service
public class StudyProgramService {

	@Autowired
	StudyProgramRepository studyProgramRepo;
	
	public StudyProgram findOne(Long id) {
		return studyProgramRepo.findOne(id);
	}
	
	public List<StudyProgram> findAll() {
		return studyProgramRepo.findAll();
	}
	
	public Page<StudyProgram> findAll(Pageable page) {
		return studyProgramRepo.findAll(page);
	}
	
	public StudyProgram save(StudyProgram studyProgram) {
		return studyProgramRepo.save(studyProgram);
	}
	
	public void remove(Long id) {
		studyProgramRepo.delete(id);
	}

}
