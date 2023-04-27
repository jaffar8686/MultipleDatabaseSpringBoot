package com.example.demo.secondary.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DocumentsPDf {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Lob
    private byte[] documentByte;

    @Column(name = "document_name")
    private String documentName;

    @Column(name = "document_size")
    private String documentSize;

    @Column(name = "document_type")
    private String documentType;
}
