package com.example.demo.secondary.repository;


import com.example.demo.secondary.model.DocumentsPDf;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentPdfRepository extends JpaRepository<DocumentsPDf,Long> {
}
