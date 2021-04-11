package com.xyzbanksvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xyzbanksvc.model.Payee;

@Repository
public interface PayeeRepository extends JpaRepository<Payee, Integer> {

	Payee modifyFavPayeeDetails(Payee payee);

}
