package com.demojavadj.appweb.services;

import com.demojavadj.appweb.models.Author;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorService {
    List<Author> getAllAuthors();
    void addAuthor(Author author);
    Author getAuthorById(Long id);
    void deleteAuthor(Long id);

}
