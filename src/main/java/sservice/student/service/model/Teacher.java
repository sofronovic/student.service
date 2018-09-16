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

@Entity
@DiscriminatorValue("teacher")
public class Teacher extends User {
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "teacherType_id", referencedColumnName = "teacherType_id")
	private TeacherType teacherType;
	
	@OneToMany(mappedBy = "teacher", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private List<CourseLecture> subjectList = new ArrayList<CourseLecture>();

	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Teacher(String username, String firstname,
			String lastname, String birthday, String email, TeacherType teacherType, List<CourseLecture> subjectList) {
		super(username, firstname, lastname, birthday, email);
		this.teacherType = teacherType;
		this.subjectList = subjectList;
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

	
}
