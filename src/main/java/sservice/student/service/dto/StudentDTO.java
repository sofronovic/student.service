package sservice.student.service.dto;

import sservice.student.service.model.Student;

public class StudentDTO {
	
	private long id;
	private String indeks;
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private String birthday;
	private String email;
	private StudyProgramDTO studyProgram;
	
	public StudentDTO() {}
	
	public StudentDTO(long id, String index, StudyProgramDTO studyProgram) {
		super();
		this.id = id;
		this.indeks = index;
		this.studyProgram = studyProgram;
	}

	
	public StudentDTO(Student student){
		id = student.getId();
		indeks = student.getIndeks();
		username = student.getUsername();
		firstname = student.getFirstname();
		lastname = student.getLastname();
		birthday = student.getBirthday();
		email = student.getEmail();
		studyProgram = new StudyProgramDTO(student.getStudyProgram());
	}
	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstame() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
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



	public String getIndeks() {
		return indeks;
	}

	public void setIndeks(String indeks) {
		this.indeks = indeks;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
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
