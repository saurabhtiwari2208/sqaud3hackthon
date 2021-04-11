package com.xyzbanksvc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.xyzbanksvc.model.UserDetails;

@Repository
public interface UserDetailsRepository extends CrudRepository<UserDetails, String> {

}
