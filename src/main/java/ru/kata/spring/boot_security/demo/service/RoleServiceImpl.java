package ru.kata.spring.boot_security.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.model.Roles;
import ru.kata.spring.boot_security.demo.repositories.RoleRepository;

import java.util.Set;

@Transactional
@Service
public class RoleServiceImpl implements RoleService {
    private RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Set<Roles> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Roles getRoleByID(Long id) {
        return roleRepository.findRoleById(id);
    }

    @Override
    public Roles getRoleByRole(String role) {
        return roleRepository.findRoleByRole(role);
    }

    @Override
    public void addRole(Roles role) {
        roleRepository.save(role);
    }
}