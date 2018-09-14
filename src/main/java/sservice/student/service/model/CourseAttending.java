package sservice.student.service.model;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.Id;

public class CourseAttending {
	
	@Id
	@GeneratedValue
	private long id;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	private Student student;
	
	@ManyToOne
	private StudyProgram studyProgram;
	
	
	

	public CourseAttending(long id, Student student, StudyProgram studyProgram) {
		super();
		this.id = id;
		this.student = student;
		this.studyProgram = studyProgram;
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
	
	
	

}
