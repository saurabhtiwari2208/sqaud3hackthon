package com.xyzbanksvc.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.xyzbanksvc.model.Payee;

@Repository
public interface PayeeRepository extends JpaRepository<Payee, Integer> {

	@Modifying
	@Query(value = "update Payee p set p.payeeName=?1, p.payeeAccountNo=?2 where p.accountNo=?3")
	int modifyFavPayeeDetails(String payeeName, String payeeAccountNo, String accountNo);

	@Query(value = "DELETE FROM Payee p where p.accountNo in ( select accountNo from UserDetails where userId=?1 and accountNo=?2) and p.payeeAccountNo=?3")
	int deleteFavPayeeDetails(String userId, String accountNo, String payeeAccountNo);

	@Query("select p from Payee p where p.userId=?1 and p.accountNo=?2")
	List<Payee> findPayeeByUserAndAccountId(String userId, String accountId, Pageable pagination);

	@Query("select p from Payee p where p.payeeAccountNo=?1")
	Payee findPayeeByAccountNo(String payeeAccountNumber);
}
