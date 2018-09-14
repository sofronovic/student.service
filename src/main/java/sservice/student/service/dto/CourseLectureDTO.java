package sservice.student.service.dto;

import sservice.student.service.model.CourseLecture;

public class CourseLectureDTO {
	
	private long id;
	
	private TeacherDTO teacher;
	
	private SubjectDTO subject;
	
	public CourseLectureDTO(){}
	
	public CourseLectureDTO(CourseLecture courseLecture)
	{
		id = courseLecture.getId();
		teacher = new TeacherDTO(courseLecture.getTeacher());
		subject = new SubjectDTO(courseLecture.getSubject());
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public TeacherDTO getTeacher() {
		return teacher;
	}

	public void setTeacher(TeacherDTO teacher) {
		this.teacher = teacher;
	}

	public SubjectDTO getSubject() {
		return subject;
	}

	public void setSubject(SubjectDTO subject) {
		this.subject = subject;
	}

	public CourseLectureDTO(long id, TeacherDTO teacher, SubjectDTO subject) {
		super();
		this.id = id;
		this.teacher = teacher;
		this.subject = subject;
	}
	
	

}
