package com.bankdetailssvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bankdetailssvc.entity.BankDetailsEntity;
import com.bankdetailssvc.repository.BankDetailsRepository;

@RestController
// @Slf4j
public class BankDetailsController {
	
	@Autowired
	private BankDetailsRepository bankDetailsRepository;

	@GetMapping(path = "/fetchBankDetails/{bankCode}")
	public BankDetailsEntity fetchBankDetails(@PathVariable String bankCode) {
		// log.info("Looking result for BankCode - {}",bankCode);
		BankDetailsEntity result =  bankDetailsRepository.findByBankCode(bankCode);
		if(null == result) {
			// log.info("No result found in DB");
			return new BankDetailsEntity();
		}
		return result;
	}
}
