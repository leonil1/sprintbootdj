package com.demojavadj.appweb.contollers;

import com.demojavadj.appweb.models.Author;
import com.demojavadj.appweb.models.Book;
import com.demojavadj.appweb.services.impl.AuthorServiceImpl;
import com.demojavadj.appweb.services.impl.BookServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/book")
public class BookController {

    private final BookServiceImpl bookService;
    private final AuthorServiceImpl authorService;


    public BookController(BookServiceImpl bookService, AuthorServiceImpl authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @GetMapping("/list-books")
    public String booksList(Model model) {
        model.addAttribute("title", "Lista de Libros");
        model.addAttribute("booksList", bookService.getAllBooks());
        return "pages/list-books";
    }

    @GetMapping("/nuevo")
    public String addBook(Model model) {
        List<Author> authors = authorService.getAllAuthors();
        model.addAttribute("title", "Nuevo Libro");
        Book book = new Book();
        model.addAttribute("book", book);
        model.addAttribute("authors", authors);
        return "pages/add-book";
    }

    @PostMapping("/save")
    public String saveAuthor(@ModelAttribute("book") Book book){
        bookService.addBooks(book);
        return "redirect:/book/list-books";
    }


}
