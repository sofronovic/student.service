package sservice.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import sservice.student.service.model.Teacher;
import sservice.student.service.repository.TeacherRepository;

@Service
public class TeacherService {
	
	@Autowired
	TeacherRepository teacherRepo;
	
	public Teacher findOne(Long id) {
		return teacherRepo.findOne(id);
	}
	
	public List<Teacher> findAll() {
		return teacherRepo.findAll();
	}
	
	public Page<Teacher> findAll(Pageable page) {
		return teacherRepo.findAll(page);
	}
	
	public Teacher save(Teacher teacher) {
		return teacherRepo.save(teacher);
	}
	
	public void remove(Long id) {
		teacherRepo.delete(id);
	}

}
