package com.demojavadj.appweb.services.impl;

import com.demojavadj.appweb.models.Book;
import com.demojavadj.appweb.repository.BookRepository;
import com.demojavadj.appweb.services.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public void addBooks(Book book) {
        bookRepository.save(book);
    }

    @Override
    public Book getBooksById(Long id) {
        return null;
    }

    @Override
    public void deleteBook(Long id) {

    }
}
