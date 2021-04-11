package com.xyzbanksvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xyzbanksvc.model.UserDetails;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails, String> {

}
