package sservice.student.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sservice.student.service.model.TeacherType;

public interface TeacherTypeRepository extends JpaRepository<TeacherType, Long> {

}
