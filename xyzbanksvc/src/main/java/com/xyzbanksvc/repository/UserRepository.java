package com.xyzbanksvc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.xyzbanksvc.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

}
