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
public class Exam {

	@Id
	@GeneratedValue
	private long id;
	
	@Column
	private String type;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "student_id", referencedColumnName = "student_id")
	private Student student;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "courseAttending_id", referencedColumnName = "courseAttending_id")
	private CourseAttending courseAttending;
	
	public Exam() {}
	
	public Exam(long id, String type, Student student, CourseAttending courseAttending, int score, float points) {
		super();
		this.id = id;
		this.type = type;
		this.student = student;
		this.courseAttending = courseAttending;
		this.score = score;
		this.points = points;
	}

	@Column
	private int score;
	
	@Column
	private float points;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public CourseAttending getCourseAttending() {
		return courseAttending;
	}

	public void setCourseAttending(CourseAttending courseAttending) {
		this.courseAttending = courseAttending;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public float getPoints() {
		return points;
	}

	public void setPoints(float points) {
		this.points = points;
	}
	
	
}
