package sservice.student.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sservice.student.service.model.CourseAttending;

public interface CourseAttendingRepository extends JpaRepository<CourseAttending, Long> {

}
