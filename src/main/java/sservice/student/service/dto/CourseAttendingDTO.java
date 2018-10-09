package sservice.student.service.dto;

import sservice.student.service.model.CourseAttending;

public class CourseAttendingDTO {

	private long id;
	private StudentDTO student;
	private SubjectDTO subject;
	
	public CourseAttendingDTO(){}
	
	public CourseAttendingDTO(CourseAttending courseAttending){
		
		id = courseAttending.getId();
		student = new StudentDTO(courseAttending.getStudent());
		subject = new SubjectDTO(courseAttending.getSubject());
	}

	public CourseAttendingDTO(long id, StudentDTO student, SubjectDTO subject) {
		super();
		this.id = id;
		this.student = student;
		this.subject = subject;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public StudentDTO getStudent() {
		return student;
	}

	public void setStudent(StudentDTO student) {
		this.student = student;
	}

	public SubjectDTO getSubject() {
		return subject;
	}

	public void setSubject(SubjectDTO subject) {
		this.subject = subject;
	}

	
	
}
