package com.xyzbanksvc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.xyzbanksvc.model.Payee;

@Repository
public interface PayeeRepository extends CrudRepository<Payee, Integer> {

}
