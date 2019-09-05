package com.example.hotelmanagementsystem.repository;

import com.example.hotelmanagementsystem.model.Role;
import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {

  Role findByName(String name);
}
