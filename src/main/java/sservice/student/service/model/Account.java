package sservice.student.service.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Account {

	@Id
	@GeneratedValue
	private long id;
	
	@Column
	private String accountNumber;
	
	@Column
	private String modelNumber;
	
	@Column
	private String referenceNumber;
	
	@Column
	private float balance;
	
	public Account() {}
	
	public Account(long id, String accountNumber, String modelNumber, String referenceNumber, float balance) {
		super();
		this.id = id;
		this.accountNumber = accountNumber;
		this.modelNumber = modelNumber;
		this.referenceNumber = referenceNumber;
		this.balance = balance;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getModelNumber() {
		return modelNumber;
	}

	public void setModelNumber(String modelNumber) {
		this.modelNumber = modelNumber;
	}

	public String getReferenceNumber() {
		return referenceNumber;
	}

	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}
}
