package sservice.student.service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import sservice.student.service.model.CourseAttending;
import sservice.student.service.repository.CourseAttendingRepository;

@Service
public class CourseAttendingService {
	
	@Autowired
	CourseAttendingRepository courseAttendingRepo;
	
	public CourseAttending findOne(Long id) {
		return courseAttendingRepo.findOne(id);
	}
	
	public List<CourseAttending> findAll() {
		return courseAttendingRepo.findAll();
	}
	
	public Page<CourseAttending> findAll(Pageable page) {
		return courseAttendingRepo.findAll(page);
	}
	
	public CourseAttending save(CourseAttending courseAttending) {
		return courseAttendingRepo.save(courseAttending);
	}
	
	public void remove(Long id) {
		courseAttendingRepo.delete(id);
	}
}
