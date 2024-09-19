package com.demojavadj.appweb.repository;

import com.demojavadj.appweb.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
