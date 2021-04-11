package com.xyzbanksvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xyzbanksvc.model.Payee;
import com.xyzbanksvc.model.PayeeDetailsRequest;
import com.xyzbanksvc.repository.PayeeRepository;

@Service
public class PayeeServiceImpl implements PayeeService {

	@Autowired
	private PayeeRepository payeeRepository;

	@Override
	public List<Payee> fetchFavPayeeDetails(PayeeDetailsRequest payeeDetailsRequest) {
		return payeeRepository.findPayeeByUserAndAccountId(payeeDetailsRequest.getUserId(),
				payeeDetailsRequest.getAccountNo(), payeeDetailsRequest.getPageNo());
	}

	@Override
	public Payee modifyFavPayeeDetails(Payee payee) {
		return payeeRepository.modifyFavPayeeDetails(payee);
	}

}
