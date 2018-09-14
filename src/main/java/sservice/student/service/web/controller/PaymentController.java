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

import sservice.student.service.dto.PaymentDTO;
import sservice.student.service.model.*;
import sservice.student.service.service.PaymentService;
import sservice.student.service.service.StudentService;


@RestController
@RequestMapping(value="api/payments")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value="/all", method = RequestMethod.GET)
	public ResponseEntity<List<PaymentDTO>> getAllPayments() {
		List<Payment> payments = paymentService.findAll();
		List<PaymentDTO> paymentsDTO = new ArrayList<>();
		for(Payment p : payments)
		{
			paymentsDTO.add(new PaymentDTO(p));
		}
		return new ResponseEntity<>(paymentsDTO, HttpStatus.OK);
		
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Payment>> getPaymentPage(Pageable page){
		Page<Payment> pagePayments = paymentService.findAll(page);
		List<Payment> payments = new ArrayList<>();
		for(Payment p : pagePayments){
			payments.add(p);
		}
		return new ResponseEntity<>(payments, HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<PaymentDTO> getPayment(@PathVariable Long id){
		Payment payment = paymentService.findOne(id);
		if(payment == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(new PaymentDTO(payment), HttpStatus.OK);
	}
	
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<PaymentDTO> savePayment(@RequestBody PaymentDTO paymentDTO){
		
		if(paymentDTO.getStudent() == null)
		{
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Student student = studentService.findOne(paymentDTO.getStudent().getId());
		if(student == null)
		{
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Payment p = new Payment();
		p.setDescription(paymentDTO.getDescription());
		p.setAmount(paymentDTO.getAmount());
		p.setDate(paymentDTO.getDate());
		p.setStudent(student);
		
		p = paymentService.save(p);
		return new ResponseEntity<>(new PaymentDTO(p), HttpStatus.CREATED);
		
		
	}
	
	@RequestMapping(method=RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<PaymentDTO> updatePayment(@RequestBody PaymentDTO paymentDTO){
		
		Payment payment = paymentService.findOne(paymentDTO.getId()); 
		if (payment == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		payment.setAmount(paymentDTO.getAmount());
		payment.setDescription(paymentDTO.getDescription());
		payment.setDate(paymentDTO.getDate());
		payment = paymentService.save(payment);
		return new ResponseEntity<>(new PaymentDTO(payment), HttpStatus.OK);	
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deletePayment(@PathVariable Long id){
		Payment payment = paymentService.findOne(id);
		if (payment != null){
			paymentService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {		
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
}
