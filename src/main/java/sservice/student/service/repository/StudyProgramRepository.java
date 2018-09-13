package sservice.student.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sservice.student.service.model.StudyProgram;

public interface StudyProgramRepository extends JpaRepository<StudyProgram, Long> {

}
