package com.xyzbanksvc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.xyzbanksvc.model.Payee;

@Repository
public interface PayeeRepository extends JpaRepository<Payee, Integer> {

	Payee modifyFavPayeeDetails(Payee payee);

	@Query("select p from Payee p")
	List<Payee> findPayeeByUserAndAccountId(String userId, String accountId, int pageNo);

	@Query("select p from Payee p where p.payeeAccountNo=?1")
	Payee findPayeeByAccountNo(String payeeAccountNumber);
}
