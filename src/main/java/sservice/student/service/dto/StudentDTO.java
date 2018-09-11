package sservice.student.service.dto;

import sservice.student.service.model.Student;

public class StudentDTO {
	
	private long id;
	private String index;

	public StudentDTO(Student student){
		id = student.getId();
		index = student.getIndex();
	}
	
	public StudentDTO() {}
	
	public StudentDTO(long id, String index) {
		super();
		this.id = id;
		this.index = index;
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
}
