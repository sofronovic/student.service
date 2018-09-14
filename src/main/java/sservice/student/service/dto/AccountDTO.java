package sservice.student.service.dto;

import sservice.student.service.model.Account;

public class AccountDTO {
	
	private long id;
	private String accountNumber;
	private String modelNumber;
	private String referenceNumber;
	private float balance;
	
	public AccountDTO(){}
	
	public AccountDTO(Account account){
		id = account.getId();
		accountNumber = account.getAccountNumber();
		modelNumber = account.getModelNumber();
		referenceNumber = account.getReferenceNumber();
		balance = account.getBalance();
	}

	public AccountDTO(long id, String accountNumber, String modelNumber, String referenceNumber, float balance) {
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
