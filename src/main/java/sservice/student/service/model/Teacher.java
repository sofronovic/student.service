package sservice.student.service.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id")
@DiscriminatorValue("teacher")
public class Teacher extends User {
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "teacherType_id", referencedColumnName = "teacherType_id")
	private TeacherType teacherType;
	
	@OneToMany(mappedBy = "teacher", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private List<CourseLecture> subjectList = new ArrayList<CourseLecture>();

	@OneToMany(mappedBy = "teacher", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private List<Exam> examList = new ArrayList<Exam>();
	
	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Teacher(String username, String firstname,
			String lastname, String birthday, String email, TeacherType teacherType, List<CourseLecture> subjectList, List<Exam> examList) {
		super(username, firstname, lastname, birthday, email);
		this.teacherType = teacherType;
		this.subjectList = subjectList;
		this.examList = examList;
	}

	public TeacherType getTeacherType() {
		return teacherType;
	}

	public void setTeacherType(TeacherType teacherType) {
		this.teacherType = teacherType;
	}

	public List<CourseLecture> getSubjectList() {
		return subjectList;
	}

	public void setSubjectList(List<CourseLecture> subjectList) {
		this.subjectList = subjectList;
	}

	public List<Exam> getExamList() {
		return examList;
	}

	public void setExamList(List<Exam> examList) {
		this.examList = examList;
	}

}
