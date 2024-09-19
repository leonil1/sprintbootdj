package com.demojavadj.appweb.contollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping("/")
    @ResponseBody
    public String home() {
        return "esto es un controlador ok";
    }

    @GetMapping("/nosotro")
    @ResponseBody
    public String nosotros(){
        return "esto es un controlador";
    }

    @GetMapping("/parametros/{id}")
    public String parametros(@PathVariable("id") long id, @PathVariable("slug") String slug){
        return "id"+ id +"| slug"+ slug;
    }

    @GetMapping("/query-string")
    @ResponseBody
    public String query_string (@RequestParam("id") Long id, @RequestParam("slug") String slug){
        return "id = "+ id +"| slug ="+ slug;
    }

}
