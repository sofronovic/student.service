package sservice.student.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sservice.student.service.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
