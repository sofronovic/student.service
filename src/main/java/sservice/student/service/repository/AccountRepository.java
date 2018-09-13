package sservice.student.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sservice.student.service.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
