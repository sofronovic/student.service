package sservice.student.service.web.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import sservice.student.service.dto.AccountDTO;
import sservice.student.service.model.*;
import sservice.student.service.service.AccountService;


@RestController
@RequestMapping(value ="api/accounts")
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@RequestMapping(value="/all", method = RequestMethod.GET)
	public ResponseEntity<List<AccountDTO>> getAllAccounts()
	{
		List<Account> accounts = accountService.findAll();
		List<AccountDTO> accountDTOs = new ArrayList<>();
		for(Account r: accounts)
		{
			accountDTOs.add(new AccountDTO(r));
		}
		return new ResponseEntity<>(accountDTOs, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Account>> getAccountPage(Pageable page)
	{
		Page<Account> pageAccounts = accountService.findAll(page);
		List<Account> racuni = new ArrayList<>();
		for(Account r: pageAccounts)
		{
			racuni.add(r);
		}
		return new ResponseEntity<>(racuni, HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<AccountDTO> getAccount(@PathVariable Long id)
	{
		Account account = accountService.findOne(id);
		if(account == null)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(new AccountDTO(account), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<AccountDTO> saveAccount(@RequestBody AccountDTO accountDTO)
	{
		
		
		Account a = new Account();
		a.setAccountNumber(accountDTO.getAccountNumber());
		a.setModelNumber(accountDTO.getModelNumber());
		a.setReferenceNumber(accountDTO.getReferenceNumber());
		a.setBalance(accountDTO.getBalance());
		a = accountService.save(a);
		
		return new ResponseEntity<>(new AccountDTO(a), HttpStatus.CREATED);
		
	}
	
	@RequestMapping(method=RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<AccountDTO> updateAccount(@RequestBody AccountDTO accountDTO)
	{
		Account account = accountService.findOne(accountDTO.getId());
		if(account == null)
		{
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		account.setAccountNumber(accountDTO.getAccountNumber());
		account.setModelNumber(accountDTO.getModelNumber());
		account.setReferenceNumber(accountDTO.getReferenceNumber());
		account.setBalance(accountDTO.getBalance());
		account = accountService.save(account);
		return new ResponseEntity<>(new AccountDTO(account), HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteAccount(@PathVariable long id)
	{
		Account account = accountService.findOne(id);
		if(account != null)
		{
			accountService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
}
