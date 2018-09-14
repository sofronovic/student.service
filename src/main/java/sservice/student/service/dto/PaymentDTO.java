package sservice.student.service.dto;

import sservice.student.service.model.Payment;

public class PaymentDTO {
	
	private long id;
	private String description;
	private String date;
	private String amount;
	private StudentDTO student;
	
	public PaymentDTO(){}
	
	public PaymentDTO(Payment payment){
		
		id = payment.getId();
		description = payment.getDescription();
		date = payment.getDate();
		amount = payment.getAmount();
		student = new StudentDTO(payment.getStudent());
	}
	
	public PaymentDTO(long id, String description, String date, String amount, StudentDTO student) {
		super();
		this.id = id;
		this.description = description;
		this.date = date;
		this.amount = amount;
		this.student = student;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public StudentDTO getStudent() {
		return student;
	}

	public void setStudent(StudentDTO student) {
		this.student = student;
	}


	
	

}
