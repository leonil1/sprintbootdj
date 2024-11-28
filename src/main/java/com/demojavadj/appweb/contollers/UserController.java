package com.demojavadj.appweb.contollers;

import com.demojavadj.appweb.dto.RegisterDto;
import com.demojavadj.appweb.models.Users;
import com.demojavadj.appweb.repository.UserRepository;
import com.demojavadj.appweb.services.impl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserServiceImpl userService;
    private final UserRepository  userRepository;

    public UserController(UserServiceImpl userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @GetMapping("/list")
    public String getAllUser(Model model) {
        List<Users> users = userService.allListUsers();
        model.addAttribute("title", "Lista de Usuarios");
        model.addAttribute("listUsers", users);
        return "pages/list-users";
    }

    @GetMapping("/nuevo")
    public String newUser(Model model){
        RegisterDto registerDto = new RegisterDto();
        model.addAttribute("title", "Registrar Usuario");
        model.addAttribute(registerDto);
        return "pages/form-user";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute RegisterDto registerDto, BindingResult result) {

        if (!registerDto.getPassword().equals(registerDto.getConfirmPassword())) {
            result.addError(
                    new FieldError("registerDto", "confirmPassword","password y confirmPassword no son iguales")
            );
        }

        Users user = userRepository.findByEmail(registerDto.getEmail());
        if (user != null){
            result.addError(
                    new FieldError("registerDto", "email", "ya existe un usuario")
            );
        }
        if (result.hasErrors()){
            return "pages/form-users";
        }
        try {
            userService.saveUser(registerDto);
        }catch (Exception ex){
            result.addError(
                    new FieldError("registerDto", "email", ex.getMessage())
            );
        }
        return "redirect:/user/list";
    }

}
