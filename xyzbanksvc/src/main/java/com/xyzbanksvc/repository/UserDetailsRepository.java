package com.xyzbanksvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.xyzbanksvc.model.UserDetails;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails, String> {
	@Query("select ud from UserDetails ud where ud.userId=?1 and ud.accountNo=?2")
	UserDetails getUserDetails(String userId, String accountNo);
}
