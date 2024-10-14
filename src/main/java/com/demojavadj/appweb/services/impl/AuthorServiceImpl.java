package com.demojavadj.appweb.services.impl;

import com.demojavadj.appweb.models.Author;
import com.demojavadj.appweb.repository.AuthorRepository;
import com.demojavadj.appweb.services.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public void addAuthor(Author author) {
         authorRepository.save(author);
    }

    @Override
    public Author getAuthorById(Long id) {
        Optional<Author> author = authorRepository.findById(id);
        Author  authorObj = null;
        if (author.isPresent()){
            authorObj = author.get();
        } else {
            throw  new RuntimeException("Author not found with id" + id);
        }
        return authorObj;
    }

    @Override
    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }


    /*
    @Override
    public Author getAuthorById(Long id) {
       Optional<Author> author = authorRepository.findById(id);
       Author authorObj = null;
       if(author.isPresent()){
           authorObj = author.get();
       }else {
           throw new RuntimeException("Author not found with id" + id);
       }
       return authorObj;
    }

    @Override
    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }

    */
}
