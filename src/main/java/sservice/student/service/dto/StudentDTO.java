package sservice.student.service.dto;

import sservice.student.service.model.Student;

public class StudentDTO {
	
	private long id;
	private String index;
	private String userName;
	private String password;
	private String name;
	private String lastName;
	private String birthday;
	private String email;
	private StudyProgramDTO studyProgram;
	
	public StudentDTO() {}
	
	public StudentDTO(long id, String index, StudyProgramDTO studyProgram) {
		super();
		this.id = id;
		this.index = index;
		this.studyProgram = studyProgram;
	}

	
	public StudentDTO(Student student){
		id = student.getId();
		index = student.getIndex();
		userName = student.getUsername();
		name = student.getFirstname();
		lastName = student.getLastname();
		birthday = student.getBirthday();
		email = student.getEmail();
		studyProgram = new StudyProgramDTO(student.getStudyProgram());
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public StudyProgramDTO getStudyProgram() {
		return studyProgram;
	}

	public void setStudyProgram(StudyProgramDTO studyProgram) {
		this.studyProgram = studyProgram;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	
}
