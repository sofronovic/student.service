package sservice.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import sservice.student.service.model.TeacherType;
import sservice.student.service.repository.TeacherTypeRepository;

@Service
public class TeacherTypeService {
	
	@Autowired
	TeacherTypeRepository teacherTypeRepo;
	
	public TeacherType findOne(Long id) {
		return teacherTypeRepo.findOne(id);
	}
	
	public List<TeacherType> findAll() {
		return teacherTypeRepo.findAll();
	}
	
	public Page<TeacherType> findAll(Pageable page) {
		return teacherTypeRepo.findAll(page);
	}
	
	public TeacherType save(TeacherType teacherType) {
		return teacherTypeRepo.save(teacherType);
	}
	
	public void remove(Long id) {
		teacherTypeRepo.delete(id);
	}

}
