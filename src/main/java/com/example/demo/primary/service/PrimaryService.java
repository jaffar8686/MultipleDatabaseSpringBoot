package com.example.demo.primary.service;


import com.example.demo.config.SentrifugoDataSourceConfig;
import com.example.demo.primary.model.Employee;
import com.example.demo.primary.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PrimaryService {

    @Autowired
    private SentrifugoDataSourceConfig sentrifugoDataSourceConfig;

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployee() {
       return  employeeRepository.findAll();
    }

    public Map<String, String> getConnectionDetails() {
        Map<String,String> details = new HashMap<>();
        details.put("Username",sentrifugoDataSourceConfig.getUsername());
        details.put("Password",sentrifugoDataSourceConfig.getPassword());
        details.put("URL",sentrifugoDataSourceConfig.getJdbcUrl());
        details.put("Connection Pool Name",sentrifugoDataSourceConfig.getPoolName());
        details.put("Connection Max Size", String.valueOf(sentrifugoDataSourceConfig.getMaximumPoolSize()));
        return details;
    }

    public List<Object> connectWithDB() {

        try {
            Connection connection = sentrifugoDataSourceConfig.getDataSource().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("   select * from SqlTraining.CUSTOMER.members ");
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println(resultSet);
            while (resultSet.next()){
                System.out.println(resultSet.getString("customer_id") + " "+ resultSet.getDate("join_date"));

            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
         return null;
    }
}
