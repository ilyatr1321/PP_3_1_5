package ru.kata.spring.boot_security.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;


@Controller
public class UserRestController {

    private final UserService userService;

    @Autowired
    public UserRestController(UserService userService, RoleService roleService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String getSinglePage(@AuthenticationPrincipal User authUser, Model model) {
        model.addAttribute("authUser", authUser);
        return "users";
    }

}