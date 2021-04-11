package com.xyzbanksvc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.xyzbanksvc.model.Payee;

@Repository
public interface PayeeRepository extends JpaRepository<Payee, Integer> {

	Payee modifyFavPayeeDetails(Payee payee);

	@Query("select p from Payee p inner join UserDetails ud inner join User u where p.accountNo=?2 and u.userId=?1")
	List<Payee> findPayeeByUserAndAccountId(String userId, String accountId, int pageNo);
}
