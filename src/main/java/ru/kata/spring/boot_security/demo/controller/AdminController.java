package ru.kata.spring.boot_security.demo.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.Roles;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;
import ru.kata.spring.boot_security.demo.service.UserServices;

import java.util.Collection;
import java.util.Set;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;
    private final RoleService roleService;

    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping
    public String getUserList(@AuthenticationPrincipal UserDetails userDetails,
                              Model model) {
        String username = userDetails.getUsername();
        User user = userService.getUserByUsername(username);
        model.addAttribute("user", user);
        model.addAttribute("userList", userService.getAllUser());
        model.addAttribute("newUser", new User());
        model.addAttribute("roleList", roleService.getAllRoles());
        return "admin";
    }

    @PostMapping(value="/new")
    public String addUser(@ModelAttribute("user") User user) {

        userService.addUser(user);
        return "redirect:/admin";
    }

    @PostMapping(value="/edit/{id}")
    public String updateUser(@ModelAttribute("user") User user, @PathVariable("id") Long id) {

        userService.updateUser(user, id);
        return "redirect:/admin";
    }

    @PostMapping("/delete/{id}")
    public String getUserId(@PathVariable(value="id") Long id) {
        userService.deleteById(id);
        return "redirect:/admin";
    }

    @GetMapping("/edit/{id}")
    public String updateForm(@PathVariable(value = "id") Long id, Model model){

        Set<Roles> roles = roleService.getAllRoles();
        model.addAttribute("listRoles", roleService.getAllRoles());
        model.addAttribute("user", userService.getUserById(id));
        return "redirect:/admin";
    }

    @GetMapping("/new")
    public String newForm(@ModelAttribute("user") User user){
        return "redirect:/admin";
    }


}