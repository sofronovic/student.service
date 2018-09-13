package sservice.student.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sservice.student.service.model.CourseLecture;

public interface CourseLectureRepository extends JpaRepository<CourseLecture, Long> {

}
