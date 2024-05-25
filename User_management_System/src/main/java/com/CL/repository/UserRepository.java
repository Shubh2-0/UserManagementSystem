package com.CL.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CL.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
