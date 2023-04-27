package com.example.demo.primary.controller;


import com.example.demo.primary.model.Employee;
import com.example.demo.primary.service.PrimaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/primary")
public class PrimaryController {

    @Autowired
    private PrimaryService primaryService;

    @GetMapping("/get/employee")
    public List<Employee> getAllEmployee(){
        return primaryService.getAllEmployee();
    }

    @GetMapping("/get/connection/details")
    public Map<String,String> getConnectionDetails(){
        return primaryService.getConnectionDetails();
    }

    @GetMapping("/connectionWithOtherDataBase")
    public List<Object> connectWithOtherDatabase(){
        return primaryService.connectWithDB();
    }
}
