package com.demojavadj.appweb.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "code_book")
    private String codeBook;
    private String name;
    private String title;
    private Date plubisher;
    private char sbn;
    @Column(name = "create_at")
    private Date createAt;
    @Column(name = "create_at")
    private Date updateAt;

    public Book() {
    }

}
