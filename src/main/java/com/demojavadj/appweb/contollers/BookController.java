package com.demojavadj.appweb.contollers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/book")
public class BookController {

    @GetMapping("/listar")
    public String listr(Model model){
        model.addAttribute("boks");
        model.addAttribute("book", "Esto es el libro");
        return "listar";
    }
}
