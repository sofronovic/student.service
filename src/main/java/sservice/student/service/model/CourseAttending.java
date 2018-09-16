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
	private long id;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "student_id", referencedColumnName = "student_id")
	private Student student;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "studyProgram_id", referencedColumnName = "studyProgram_id")
	private StudyProgram studyProgram;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "subject_id", referencedColumnName = "subject_id")
	private Subject subject;
	
	public CourseAttending(long id, Student student, StudyProgram studyProgram, Subject subject) {
		super();
		this.id = id;
		this.student = student;
		this.studyProgram = studyProgram;
		this.subject = subject;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public StudyProgram getStudyProgram() {
		return studyProgram;
	}

	public void setStudyProgram(StudyProgram studyProgram) {
		this.studyProgram = studyProgram;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}
}
