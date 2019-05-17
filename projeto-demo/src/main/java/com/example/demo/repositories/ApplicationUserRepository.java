package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.ApplicationUser;

@Repository
public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long> {

	ApplicationUser findByUserName(String userName);
}
