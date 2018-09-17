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

@Entity
@PrimaryKeyJoinColumn(name = "student_id")
@DiscriminatorValue("student")
public class Student extends User {

	@Column(unique = true, nullable = false)
	private String index;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "studyProgram_id", referencedColumnName = "studyProgram_id")
	private StudyProgram studyProgram;
	
	@OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private List<Document> documentList = new ArrayList<Document>();
	
	@OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private List<Exam> examList = new ArrayList<Exam>();
	
	@OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private List<Payment> paymentList = new ArrayList<Payment>();
	
	@OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private List<CourseAttending> courseList = new ArrayList<CourseAttending>();
	
	public Student() {
		super();
	}
	
	public Student(String username, String firstname, String lastname, String birthday, String email,
			String index, StudyProgram studyProgram, List<Document> documentList, List<Exam> examList,
			List<Payment> paymentList, List<CourseAttending> courseList) {
		super(username, firstname, lastname, birthday, email);
		this.index = index;
		this.studyProgram = studyProgram;
		this.documentList = documentList;
		this.examList = examList;
		this.courseList = courseList;
		this.paymentList = paymentList;
	}

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}
}