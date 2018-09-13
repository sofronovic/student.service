package sservice.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import sservice.student.service.model.Payment;
import sservice.student.service.repository.PaymentRepository;

@Service
public class PaymentService {
	
	@Autowired
	PaymentRepository paymentRepo;
	
	public Payment findOne(Long id) {
		return paymentRepo.findOne(id);
	}
	
	public List<Payment> findAll() {
		return paymentRepo.findAll();
	}
	
	public Page<Payment> findAll(Pageable page) {
		return paymentRepo.findAll(page);
	}
	
	public Payment save(Payment payment) {
		return paymentRepo.save(payment);
	}
	
	public void remove(Long id) {
		paymentRepo.delete(id);
	}

}
