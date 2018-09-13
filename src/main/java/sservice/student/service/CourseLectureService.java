package sservice.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import sservice.student.service.model.CourseLecture;
import sservice.student.service.repository.CourseLectureRepository;

@Service
public class CourseLectureService {

	@Autowired
	CourseLectureRepository courseLectureRepo;
	
	public CourseLecture findOne(Long id) {
		return courseLectureRepo.findOne(id);
	}
	
	public List<CourseLecture> findAll() {
		return courseLectureRepo.findAll();
	}
	
	public Page<CourseLecture> findAll(Pageable page) {
		return courseLectureRepo.findAll(page);
	}
	
	public CourseLecture save(CourseLecture courseLecture) {
		return courseLectureRepo.save(courseLecture);
	}
	
	public void remove(Long id) {
		courseLectureRepo.delete(id);
	}

}
