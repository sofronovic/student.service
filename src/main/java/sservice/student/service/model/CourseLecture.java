package sservice.student.service.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CourseLecture {

	@Id
	@GeneratedValue
	@Column(name = "courseLecture_id")
	private long id;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "id", referencedColumnName = "id")
	private Teacher teacher;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "subject_id", referencedColumnName = "subject_id")
	private Subject subject;
	
	public CourseLecture(long id, Teacher teacher, Subject subject) {
		super();
		this.id = id;
		this.teacher = teacher;
		this.subject = subject;
	}
	
	public CourseLecture(){}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	
}
