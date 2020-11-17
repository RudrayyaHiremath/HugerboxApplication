package com.hungerbox.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hungerbox.app.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
