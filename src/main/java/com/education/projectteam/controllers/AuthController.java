package com.education.projectteam.controllers;

import com.education.projectteam.Dto.UserDto;
import com.education.projectteam.models.User;
import com.education.projectteam.repo.UserRepository;
import com.education.projectteam.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class AuthController {

    final private UserService userService;

    final private UserRepository userRepository;

    public AuthController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @GetMapping("/main")
    public String home(){
        return "home";
    }

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

    // handler method to handle user registration request
    @GetMapping("register")
    public String showRegistrationForm(Model model){
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "register";
    }

    // handler method to handle register user form submit request
    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("user") UserDto user,
                               BindingResult result,
                               Model model){
        User existing = userService.findByEmail(user.getEmail());
        if (existing != null) {
            result.rejectValue("email", null, "There is already an account registered with that email");
        }
        if (result.hasErrors()) {
            model.addAttribute("user", user);
            return "register";
        }

        userService.saveUser(user);
        return "redirect:/register?success";
    }

    @GetMapping("/users")
    public String listRegisteredUsers(Model model){
        List<UserDto> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/profile/{id}")
    public String listRegisteredUsers(@PathVariable(value = "id") long id, Model model){
        if(!userRepository.existsById(id)){
            return "redirect:/main";
        }
        Optional<User> post =  userRepository.findById(id);
        ArrayList<User> result = new ArrayList<>();
        post.ifPresent(result::add);
        model.addAttribute("user",result);
        return "profile";
    }

    @GetMapping("/profile/{id}/update")
    public String userProfileEdit(@PathVariable(value = "id") long id, Model model) {
        if(!userRepository.existsById(id)){
            return "redirect:/home";
        }
        Optional<User> post =  userRepository.findById(id);
        ArrayList<User> result = new ArrayList<>();
        post.ifPresent(result::add);
        model.addAttribute("user",result);
        return "profile";
    }
    @PostMapping("/profile/{id}/update")
    public String BlogPostUpdate (@PathVariable(value = "id") long id, @RequestParam String name, @RequestParam String email , @RequestParam String password, Model model) {
        User user = userRepository.findById(id).orElseThrow();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        userRepository.save(user);
        return "redirect:/profile";
    }
}