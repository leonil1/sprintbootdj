package com.demojavadj.appweb.contollers;

import com.demojavadj.appweb.services.impl.BookServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    private final BookServiceImpl bookService;

    public BookController(BookServiceImpl bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/list-books")
    public String booksList(Model model) {
        model.addAttribute("title", "Lista de Libros");
        model.addAttribute("booksList", bookService.getAllBooks());
        return "page/list-books";
    }

    @GetMapping("/listar")
    public String listr(Model model){
        model.addAttribute("boks");
        model.addAttribute("book", "Esto es el libro");
        return "listar";
    }

    @GetMapping("/atributo")
    public String atributos(Model model){
        Integer numero1 = 12;
        Integer numero2 = 13;
        Integer cifra = 12345;
        Date fecha = new Date();
        List<String> paises = new ArrayList<String>();
        paises.add("Peru");
        paises.add("Madrid");
        paises.add("Malta");
        paises.add("Rome");

        model.addAttribute("numero1", numero1);
        model.addAttribute("numero2", numero2);
        model.addAttribute("cifra", cifra);
        model.addAttribute("fecha", fecha);
        model.addAttribute("paises", paises);
        return "template/atributos";
    }
}
