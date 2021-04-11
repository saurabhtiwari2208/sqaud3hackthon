package com.bankdetailssvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankdetailssvc.entity.BankDetailsEntity;

@Repository
public interface BankDetailsRepository extends JpaRepository<BankDetailsEntity, Long>{

	public BankDetailsEntity findByBankCode(String bankCode);
}
