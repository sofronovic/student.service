package sservice.student.service.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@PrimaryKeyJoinColumn(name = "id")
@DiscriminatorValue("student")
public class Student extends User {

	@Column
	private String indeks;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "studyProgram_id", referencedColumnName = "studyProgram_id")
	private StudyProgram studyProgram;
	
	@JsonIgnore
	@OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private List<Document> documentList = new ArrayList<Document>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private List<Exam> examList = new ArrayList<Exam>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private List<Payment> paymentList = new ArrayList<Payment>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private List<CourseAttending> courseList = new ArrayList<CourseAttending>();
	
	public Student() {
		super();
	}
	
	public Student(String username, String firstname, String lastname, String birthday,
			String email, String indeks, StudyProgram studyProgram, List<Document> documentList, List<Exam> examList, 
			List<Payment> paymentList, List<CourseAttending> courseList) {
		super(username, firstname, lastname, birthday, email);
		this.indeks = indeks;
		this.studyProgram = studyProgram;
		this.documentList = documentList;
		this.examList = examList;
		this.paymentList = paymentList;
		this.courseList = courseList;
	}

	public String getIndex() {
		return indeks;
	}

	public void setIndex(String index) {
		this.indeks = index;
	}

	public StudyProgram getStudyProgram() {
		return studyProgram;
	}

	public void setStudyProgram(StudyProgram studyProgram) {
		this.studyProgram = studyProgram;
	}

	public List<Document> getDocumentList() {
		return documentList;
	}

	public void setDocumentList(List<Document> documentList) {
		this.documentList = documentList;
	}

	public List<Exam> getExamList() {
		return examList;
	}

	public void setExamList(List<Exam> examList) {
		this.examList = examList;
	}

	public List<Payment> getPaymentList() {
		return paymentList;
	}

	public void setPaymentList(List<Payment> paymentList) {
		this.paymentList = paymentList;
	}

	public List<CourseAttending> getCourseList() {
		return courseList;
	}

	public void setCourseList(List<CourseAttending> courseList) {
		this.courseList = courseList;
	}
}