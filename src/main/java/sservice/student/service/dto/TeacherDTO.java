package sservice.student.service.dto;

import sservice.student.service.model.Teacher;

public class TeacherDTO {
	
	private long id;
	private TeacherTypeDTO teacherType;
	
	public TeacherDTO(Teacher teacher){
		
		id = teacher.getId();
		teacherType = new TeacherTypeDTO(teacher.getTeacherType());
	}
	
	public TeacherDTO(){}
	
	public TeacherDTO(long id, TeacherTypeDTO teacherType) {
		super();
		this.id = id;
		this.teacherType = teacherType;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public TeacherTypeDTO getTeacherType() {
		return teacherType;
	}
	public void setTeacherType(TeacherTypeDTO teacherType) {
		this.teacherType = teacherType;
	}
	
	
	

}
