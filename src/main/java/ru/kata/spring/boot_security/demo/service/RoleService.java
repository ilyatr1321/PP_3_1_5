package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.model.Roles;

import java.util.Set;

public interface RoleService {
    Set<Roles> getAllRoles();
    Roles getRoleByID(Long id);
    Roles getRoleByRole(String role);
    void addRole(Roles role);
}
