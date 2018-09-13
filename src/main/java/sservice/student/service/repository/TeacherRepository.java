package sservice.student.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sservice.student.service.model.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

}
