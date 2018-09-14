package sservice.student.service.dto;

import sservice.student.service.model.TeacherType;

public class TeacherTypeDTO {
	
	private long id;
	private String name;
	
	public TeacherTypeDTO(TeacherType teacherType){
		id = teacherType.getId();
		name = teacherType.getName();
	}
	
	public TeacherTypeDTO(){}
	
	public TeacherTypeDTO(long id, String name) {
		super();
		this.id = id;
		this.name = name;
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
	
	

}
