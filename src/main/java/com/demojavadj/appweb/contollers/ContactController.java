package com.demojavadj.appweb.contollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/contact")
public class ContactController {

    @GetMapping("/listar")
    @ResponseBody
    public String verContacto(){
        return "hola mundo con rutas";
    }

    @GetMapping("/suma")
    @ResponseBody
    public int suma(){
        int suma = 0;
        int munero = 12;
        int numero2 = 20;
        suma = munero + numero2;
        return suma;
    }

    @GetMapping("/parametro/{id}")
    @ResponseBody
    public String other(@PathVariable("id") int id){
        return "ruta con parametros" + id;
    }
}
