package com.example.demo.mysql.repository;

import com.example.demo.mysql.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users,Integer> {
}
