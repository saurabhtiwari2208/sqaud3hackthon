package com.xyzbanksvc.service;

import org.springframework.stereotype.Service;

import com.xyzbanksvc.model.BankDetailsEntity;

@Service
public interface BankService {
	BankDetailsEntity getBankDetails(String bankCode);
}
