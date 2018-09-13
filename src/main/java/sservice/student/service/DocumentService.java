package sservice.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import sservice.student.service.model.Document;
import sservice.student.service.repository.DocumentRepository;

@Service
public class DocumentService {

	@Autowired
	DocumentRepository documentRepo;
	
	public Document findOne(Long id) {
		return documentRepo.findOne(id);
	}
	
	public List<Document> findAll() {
		return documentRepo.findAll();
	}
	
	public Page<Document> findAll(Pageable page) {
		return documentRepo.findAll(page);
	}
	
	public Document save(Document doc) {
		return documentRepo.save(doc);
	}
	
	public void remove(Long id) {
		documentRepo.delete(id);
	}

}
