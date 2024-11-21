package com.demojavadj.appweb.contollers;


import com.demojavadj.appweb.models.Student;
import com.demojavadj.appweb.services.impl.StudentServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    private final StudentServiceImpl studentService;

    public StudentController(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/list-students")
    public String geAllStudents(Model model){
        List<Student> students = studentService.getStudents();
        model.addAttribute("Title", "Listar Estudiantes");
        model.addAttribute("listStudents", students);
        return "pages/listStudents";
    }
}
