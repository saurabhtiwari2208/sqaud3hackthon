package com.xyzbanksvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xyzbanksvc.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
