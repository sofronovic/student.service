package sservice.student.service.dto;

import sservice.student.service.model.StudyProgram;

public class StudyProgramDTO {
	
	
	private long id;
	private String name;
	private int duration;
	private String courseType;
	
	
	public StudyProgramDTO(){}
	
	public StudyProgramDTO(StudyProgram studyProgram)
	{
		id = studyProgram.getId();
		name = studyProgram.getName();
		duration = studyProgram.getDuration();
		courseType = studyProgram.getCourseType();
	}
	
	public StudyProgramDTO(long id, String name, int duration, String courseType) {
		super();
		this.id = id;
		this.name = name;
		this.duration = duration;
		this.courseType = courseType;
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
	
	

}
