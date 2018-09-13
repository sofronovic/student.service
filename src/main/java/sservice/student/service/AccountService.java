package sservice.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import sservice.student.service.model.Account;
import sservice.student.service.repository.AccountRepository;

@Service
public class AccountService {

	@Autowired
	AccountRepository accountRepo;
	
	public Account findOne(Long id) {
		return accountRepo.findOne(id);
	}
	
	public List<Account> findAll() {
		return accountRepo.findAll();
	}
	
	public Page<Account> findAll(Pageable page) {
		return accountRepo.findAll(page);
	}
	
	public Account save(Account account) {
		return accountRepo.save(account);
	}
	
	public void remove(Long id) {
		accountRepo.delete(id);
	}
}
