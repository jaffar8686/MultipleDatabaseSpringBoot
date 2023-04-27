package com.example.demo.secondary.service;


import com.example.demo.secondary.model.DocumentsPDf;
import com.example.demo.secondary.repository.DocumentPdfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecondaryService {

    @Autowired
    private DocumentPdfRepository documentPdfRepository;

    public List<DocumentsPDf> getDocuments() {

        return documentPdfRepository.findAll();
    }
}
