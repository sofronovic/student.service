package sservice.student.service.dto;

import sservice.student.service.model.Teacher;

public class TeacherDTO {
	
	private long id;
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private String birthday;
	private String email;
	private TeacherTypeDTO teacherType;
	
	public TeacherDTO(Teacher teacher){
		
		id = teacher.getId();
		username = teacher.getUsername();
		firstname = teacher.getFirstname();
		lastname = teacher.getLastname();
		birthday = teacher.getBirthday();
		email = teacher.getEmail();
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return firstname;
	}

	public void setName(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
