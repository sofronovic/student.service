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
public class Payment {
	
	@Id
	@GeneratedValue
	private long paymentId;

	@Column
	private String description;

	@Column
	private String date;
	
	@Column
	private String amount;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "id", referencedColumnName = "id")
	private Student student;

	public Payment(long id, String description, String date, String amount, Student student) {
		super();
		this.paymentId = id;
		this.description = description;
		this.date = date;
		this.amount = amount;
		this.student = student;
	}
	
	public Payment(){
		super();
	}

	public long getId() {
		return paymentId;
	}

	public void setId(long id) {
		this.paymentId = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
}
