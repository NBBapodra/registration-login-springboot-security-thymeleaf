package com.example.login.and.Registration.repository;

import com.example.login.and.Registration.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{

	User findByEmail(String email);
}