package sservice.student.service.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Document {

	@Id
	@GeneratedValue
	private long id;
	
	@Column
	private String name;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	@JoinColumn
	private Student student;

	public Document() {
		super();
	}
	
	public Document(long id, String name, Student student) {
		super();
		this.id = id;
		this.name = name;
		this.student = student;
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

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	
}