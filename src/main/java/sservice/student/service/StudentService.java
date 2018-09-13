package sservice.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import sservice.student.service.model.Student;
import sservice.student.service.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepo;
	
	public Student findOne(Long id) {
		return studentRepo.findOne(id);
	}
	
	public List<Student> findAll() {
		return studentRepo.findAll();
	}
	
	public Page<Student> findAll(Pageable page) {
		return studentRepo.findAll(page);
	}
	
	public Student save(Student student) {
		return studentRepo.save(student);
	}
	
	public void remove(Long id) {
		studentRepo.delete(id);
	}

}
