package sservice.student.service.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Teacher extends User {

	@Id
	@GeneratedValue
	private long id;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "teacherType_id", referencedColumnName = "teacherType_id")
	private TeacherType teacherType;
	
	@OneToMany(mappedBy = "teacher", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private List<CourseLecture> subjectList = new ArrayList<CourseLecture>();

	
	
	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Teacher(long id, String username, String firstname,
			String lastname, String birthday, String email, TeacherType teacherType, List<CourseLecture> subjectList) {
		super(id, username, firstname, lastname, birthday, email);
		this.id = id;
		this.teacherType = teacherType;
		this.subjectList = subjectList;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
