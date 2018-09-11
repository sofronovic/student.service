package sservice.student.service.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "student_id")
public class Student {

	@Id
	@GeneratedValue
	private long id;
	
	@Column(unique = true, nullable = false)
	private String index;

	public Student() {}
	
	public Student(long id, String index) {
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
