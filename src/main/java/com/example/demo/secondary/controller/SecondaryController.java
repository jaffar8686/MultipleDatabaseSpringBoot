package com.example.demo.secondary.controller;


import com.example.demo.secondary.model.DocumentsPDf;
import com.example.demo.secondary.service.SecondaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/secondary")
public class SecondaryController {

    @Autowired
    private SecondaryService secondaryService;

    @GetMapping("/get/all/documents")
    public List<DocumentsPDf> getDocuments(){
        return secondaryService.getDocuments();
    }
}
