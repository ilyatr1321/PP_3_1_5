package ru.kata.spring.boot_security.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.model.Roles;

import java.util.Set;

@Repository
public interface RoleRepository extends CrudRepository<Roles, Long> {
    Set<Roles> findAll();
    Roles findRoleByRole(String role);
    Roles findRoleById(Long id);
}
