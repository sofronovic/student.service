package sservice.student.service.dto;

import sservice.student.service.model.Exam;

public class ExamDTO {

	private long id;
	private String type;
	private int score;
	private float points;
	private StudentDTO student;
	private SubjectDTO subject;
	private TeacherDTO teacher;
	
	public ExamDTO(){}
	
	public ExamDTO(Exam exam){
		id = exam.getId();
		type = exam.getType();
		score = exam.getScore();
		points = exam.getPoints();
		student = new StudentDTO(exam.getStudent());
		subject = new SubjectDTO(exam.getSubject());
		teacher = new TeacherDTO(exam.getTeacher());
	}

	public ExamDTO(long id, String type, int score, float points, StudentDTO student, SubjectDTO subject, TeacherDTO teacher) {
		super();
		this.id = id;
		this.type = type;
		this.score = score;
		this.points = points;
		this.student = student;
		this.subject = subject;
		this.teacher = teacher;
	}

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

	public TeacherDTO getTeacher() {
		return teacher;
	}

	public void setTeacher(TeacherDTO teacher) {
		this.teacher = teacher;
	}
}
