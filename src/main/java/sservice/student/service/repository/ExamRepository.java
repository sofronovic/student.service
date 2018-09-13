package sservice.student.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sservice.student.service.model.Exam;

public interface ExamRepository extends JpaRepository<Exam, Long> {

}
