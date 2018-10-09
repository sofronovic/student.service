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
public class CourseAttending {
	
	@Id
	@GeneratedValue
	@Column(name = "courseAttending_id")
	private long courseAttendingId;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	@JoinColumn
	private Student student;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "subject_id", referencedColumnName = "subject_id")
	private Subject subject;
	
	public CourseAttending() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CourseAttending(long id, Student student, Subject subject) {
		super();
		this.courseAttendingId = id;
		this.student = student;
		this.subject = subject;
	}

	public long getId() {
		return courseAttendingId;
	}

	public void setId(long id) {
		this.courseAttendingId = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}
}
