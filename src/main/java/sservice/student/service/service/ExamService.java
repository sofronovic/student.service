package sservice.student.service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import sservice.student.service.model.Exam;
import sservice.student.service.repository.ExamRepository;

@Service
public class ExamService {

	@Autowired
	ExamRepository examRepo;
	
	public Exam findOne(Long id) {
		return examRepo.findOne(id);
	}
	
	public List<Exam> findAll() {
		return examRepo.findAll();
	}
	
	public Page<Exam> findAll(Pageable page) {
		return examRepo.findAll(page);
	}
	
	public Exam save(Exam exam) {
		return examRepo.save(exam);
	}
	
	public void remove(Long id) {
		examRepo.delete(id);
	}
}
