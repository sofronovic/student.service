package sservice.student.service.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class TeacherType {

	@Id
	@GeneratedValue
	private long id;
	
	@Column
	private String name;
	
	@OneToMany(mappedBy = "teacherType", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private List<Teacher> teacherList = new ArrayList<Teacher>();
	
	public TeacherType(long id, String name, List<Teacher> teacherList) {
		super();
		this.id = id;
		this.name = name;
		this.teacherList = teacherList;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Teacher> getTeacherList() {
		return teacherList;
	}

	public void setTeacherList(List<Teacher> teacherList) {
		this.teacherList = teacherList;
	}
}
