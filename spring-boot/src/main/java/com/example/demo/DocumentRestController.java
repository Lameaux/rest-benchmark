package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class DocumentRestController {

    @Autowired
    private DocumentRepository repository;

    @GetMapping("/documents")
    public Document index() {
        Pageable pageableRequest = PageRequest.of(0, 1);
        Page<Document> page = repository.findAll(pageableRequest);
        List<Document> document = page.getContent();
        return document.get(0);
    }

    @PostMapping("/documents")
    public Document create() {
        Document doc = new Document("Document " + UUID.randomUUID().toString());
        repository.save(doc);
        return doc;
    }
}
