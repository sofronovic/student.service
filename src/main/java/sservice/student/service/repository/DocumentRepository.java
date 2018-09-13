package sservice.student.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sservice.student.service.model.Document;

public interface DocumentRepository extends JpaRepository<Document, Long> {

}
