package com.xyzbanksvc.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xyzbanksvc.model.Payee;
import com.xyzbanksvc.model.PayeeDetailsRequest;
import com.xyzbanksvc.model.UserDetails;
import com.xyzbanksvc.repository.PayeeRepository;
import com.xyzbanksvc.repository.UserDetailsRepository;
import com.xyzbanksvc.repository.UserRepository;

@Service
public class PayeeServiceImpl implements PayeeService {

	@Autowired
	private PayeeRepository payeeRepository;
	@Autowired
	private UserDetailsRepository userDetailsRepository;

	@Override
	public List<Payee> fetchFavPayeeDetails(PayeeDetailsRequest payeeDetailsRequest) {
		return payeeRepository.findPayeeByUserAndAccountId(payeeDetailsRequest.getUserId(),
				payeeDetailsRequest.getAccountNo(), payeeDetailsRequest.getPageNo());
	}

	@Override
	public Payee modifyFavPayeeDetails(Payee payee) {
		return payeeRepository.modifyFavPayeeDetails(payee);
	}

	@Override
	public String addPayeeDetails(Payee payee) {
		UserDetails details = userDetailsRepository.getUserDetails(payee.getUserId(), payee.getAccountNo());
		if (Objects.isNull(details)) {
			return "Invalid UserId or Account ID";
		}
		Payee payeeExists = payeeRepository.findPayeeByAccountNo(payee.getPayeeAccountNo());
		if (Objects.nonNull(payeeExists)) {
			return "Payee Data Already Exists";
		}
		payeeRepository.save(payee);
		return "Data Saved Successfully";
	}

}
