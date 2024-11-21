package com.demojavadj.appweb.contollers;


import com.demojavadj.appweb.models.Author;
import com.demojavadj.appweb.services.impl.AuthorServiceImpl;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @GetMapping("/nuevo")
    public  String addAuthor(Model model){
        Author author = new Author();
        model.addAttribute("title", "Agregar Autor");
        model.addAttribute("author", author);
        return "pages/form-author";
    }

    @PostMapping("/save")
    public String saveAuthor(@ModelAttribute("author") Author author, @Valid BindingResult bindingResult,
                             RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            return "pages/form-author";
        }
        authorService.addAuthor(author);
        redirectAttributes
                .addFlashAttribute("message", "El author se ha guardado correctamente")
                .addAttribute("clase", "success");
        return "redirect:/author/list-allauthor";
    }

    @GetMapping("/showUpdateAuthor/{id}")
    public String updateAuthor(@PathVariable(value = "id") Long id, Model model){
        Author author = authorService.getAuthorById(id);
        model.addAttribute("author", author);
        return "pages/form-updateAuthor";
    }

    @GetMapping("/delete-author/{id}")
    public String deleteAuthor(@PathVariable(value = "id") Long id){
        authorService.deleteAuthor(id);
        return "redirect:/author/list-allauthor";
    }

}
