package com.demojavadj.appweb.services;

import com.demojavadj.appweb.models.Author;
import com.demojavadj.appweb.models.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();
    void addBooks(Book book);
    Book getBooksById(Long id);
    void deleteBook(Long id);
}
