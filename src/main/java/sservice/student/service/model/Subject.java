package sservice.student.service.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Subject {

	@GeneratedValue
	@Id
	private long id;
	
	@Column
	private String label;

	@Column
	private String name;

	@Column
	private int ects;
	
	@ManyToOne
	private StudyProgram studyProgram;
	
	
	@OneToMany(mappedBy = "subject", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private List<CourseLecture> courseLectureList = new ArrayList<CourseLecture>();
	
	@OneToMany(mappedBy = "subject", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private List<CourseAttending> courseAttendingList = new ArrayList<CourseAttending>();

	public Subject(){}
	
	public Subject(long id, String label, String name, int ects, List<CourseLecture> courseLectureList,
			List<CourseAttending> courseAttendingList, StudyProgram studyProgram) {
		super();
		this.id = id;
		this.label = label;
		this.name = name;
		this.ects = ects;
		this.courseLectureList = courseLectureList;
		this.courseAttendingList = courseAttendingList;
		this.studyProgram = studyProgram;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEcts() {
		return ects;
	}

	public void setEcts(int ects) {
		this.ects = ects;
	}

	public List<CourseLecture> getCourseLectureList() {
		return courseLectureList;
	}

	public void setCourseLectureList(List<CourseLecture> courseLectureList) {
		this.courseLectureList = courseLectureList;
	}

	public List<CourseAttending> getCourseAttendingList() {
		return courseAttendingList;
	}

	public void setCourseAttendingList(List<CourseAttending> courseAttendingList) {
		this.courseAttendingList = courseAttendingList;
	}
	
	public StudyProgram getStudyProgram() {
		return studyProgram;
	}

	public void setStudyProgram(StudyProgram studyProgram) {
		this.studyProgram = studyProgram;
	}
	
	
}