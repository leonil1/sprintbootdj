package com.demojavadj.appweb.contollers;


import com.demojavadj.appweb.models.Author;
import com.demojavadj.appweb.services.impl.AuthorServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/author")
public class AuthorController {

    private final AuthorServiceImpl authorService;

    public AuthorController(AuthorServiceImpl authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/list-allauthor")
    public String listAllAuthors(Model model) {
        model.addAttribute("title", "Lista de Auttores");
        model.addAttribute("listaAuthor", authorService.getAllAuthors());
        return "pages/list-author";
    }

    @GetMapping("/listar-autor")
    public String listAuthors(Model model){
        model.addAttribute("title", "Lista de Auttores");
        model.addAttribute("listaAuthor", authorService.getAllAuthors());
        return "autor";
    }

    @GetMapping("/nuevo")
    public  String addAuthor(Model model){
        Author author = new Author();
        model.addAttribute("title", "Agregar Autor");
        model.addAttribute("author", author);
        return "pages/form-author";
    }

    @PostMapping("save")
    public String saveAuthor(@ModelAttribute("author") Author author){
        authorService.addAuthor(author);
        return "redirect:/";
    }
}
