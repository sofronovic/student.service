package sservice.student.service.dto;

import sservice.student.service.model.Document;

public class DocumentDTO {
	
	private long id;
	private String name;
	private StudentDTO student;
	
	
	public DocumentDTO(){}
	
	public DocumentDTO(Document document){
		id = document.getId();
		name = document.getName();
		student = new StudentDTO(document.getStudent());
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

	public StudentDTO getStudent() {
		return student;
	}

	public void setStudent(StudentDTO student) {
		this.student = student;
	}

	public DocumentDTO(long id, String name, StudentDTO student) {
		super();
		this.id = id;
		this.name = name;
		this.student = student;
	}
	
	
}
