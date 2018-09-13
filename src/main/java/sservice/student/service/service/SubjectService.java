package sservice.student.service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import sservice.student.service.model.Subject;
import sservice.student.service.repository.SubjectRepository;

@Service
public class SubjectService {

	@Autowired
	SubjectRepository subjectRepo;
	
	public Subject findOne(Long id) {
		return subjectRepo.findOne(id);
	}
	
	public List<Subject> findAll() {
		return subjectRepo.findAll();
	}
	
	public Page<Subject> findAll(Pageable page) {
		return subjectRepo.findAll(page);
	}
	
	public Subject save(Subject subject) {
		return subjectRepo.save(subject);
	}
	
	public void remove(Long id) {
		subjectRepo.delete(id);
	}

}
