package sservice.student.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sservice.student.service.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
