package sservice.student.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sservice.student.service.model.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Long> {

}
