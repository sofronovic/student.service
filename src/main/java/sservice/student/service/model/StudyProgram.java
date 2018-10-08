package sservice.student.service.model;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class StudyProgram {

	@Id
	@GeneratedValue
	@Column(name = "studyProgram_id")
	private long id;
	
	@Column
	private String name;
	
	@Column
	private int duration;
	
	@Column
	private String courseType;
	
	@JsonIgnore
	@OneToMany(mappedBy = "studyProgram", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private List<Student> studentList = new ArrayList<Student>();

	public StudyProgram() {}
	
	public StudyProgram(long id, String name, int duration, String courseType, List<Student> studentList) {
		super();
		this.id = id;
		this.name = name;
		this.duration = duration;
		this.courseType = courseType;
		this.studentList = studentList;
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

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getCourseType() {
		return courseType;
	}

	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}
}
