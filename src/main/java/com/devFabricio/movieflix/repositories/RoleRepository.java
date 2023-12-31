package com.devFabricio.movieflix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devFabricio.movieflix.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
