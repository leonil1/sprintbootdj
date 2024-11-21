package com.demojavadj.appweb.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "code_book")
    @NotNull(message = "Debes especificar el codigo")
    @Size(min = 1, max = 50, message = "El nombre debe medir entre 1 y 50")
    private String codeBook;
    private String name;
    private String title;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date plubisher;
    private char sbn;
    @Column(name = "create_at")
    private Date createAt;
    @Column(name = "update_at")
    private Date updateAt;

    @ManyToOne
    @JoinColumn(name = "id_author")
    private Author author;

    public Book() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodeBook() {
        return codeBook;
    }

    public void setCodeBook(String codeBook) {
        this.codeBook = codeBook;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPlubisher() {
        return plubisher;
    }

    public void setPlubisher(Date plubisher) {
        this.plubisher = plubisher;
    }

    public char getSbn() {
        return sbn;
    }

    public void setSbn(char sbn) {
        this.sbn = sbn;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
