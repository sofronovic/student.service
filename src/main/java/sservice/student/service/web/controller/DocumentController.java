package sservice.student.service.web.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import sservice.student.service.dto.DocumentDTO;
import sservice.student.service.model.*;
import sservice.student.service.service.DocumentService;
import sservice.student.service.service.StudentService;

@RestController
@RequestMapping(value="api/documents")
public class DocumentController {
	
	@Autowired
	private DocumentService documentService;
	
	@Autowired
	private StudentService studentService;
	
	
	@RequestMapping(value="/all", method = RequestMethod.GET)
	public ResponseEntity<List<DocumentDTO>> getAllDocuments(){
		
		List<Document> documents = documentService.findAll();
		List<DocumentDTO> documentDTOs = new ArrayList<>();
		for(Document d : documents){
			documentDTOs.add(new DocumentDTO(d));
		}
		
		return new ResponseEntity<>(documentDTOs, HttpStatus.OK);
	}	
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<DocumentDTO> getDocument(@PathVariable Long id){
		
		Document document = documentService.findOne(id);
		if(document == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(new DocumentDTO(document), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<DocumentDTO> saveDocument(@RequestBody DocumentDTO documentDTO){
		
		if(documentDTO.getStudent() == null){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Student student = studentService.findOne(documentDTO.getStudent().getId());
		if (student == null){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		
		Document document = new Document();
		document.setName(documentDTO.getName());
		document.setStudent(student);
		
		document = documentService.save(document);
		return new ResponseEntity<>(new DocumentDTO(document), HttpStatus.CREATED);
	}
	

	@RequestMapping(method=RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<DocumentDTO> updateDocument(@RequestBody DocumentDTO documentDTO){
		
		Document document = documentService.findOne(documentDTO.getId()); 
		if (document == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		document.setName(documentDTO.getName());
		
		document = documentService.save(document);
		return new ResponseEntity<>(new DocumentDTO(document), HttpStatus.OK);	
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteDocument(@PathVariable Long id){
		
		Document document = documentService.findOne(id);
		if (document != null){
			documentService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {		
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
