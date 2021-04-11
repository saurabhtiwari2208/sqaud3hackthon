package com.xyzbanksvc.service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.xyzbanksvc.model.Payee;
import com.xyzbanksvc.model.PayeeDetailsRequest;
import com.xyzbanksvc.model.PayeeResponse;
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
	public List<PayeeResponse> fetchFavPayeeDetails(PayeeDetailsRequest payeeDetailsRequest) {
		Pageable pagination = PageRequest.of(0, 5);
		List<Payee> payeeDetails = payeeRepository.findPayeeByUserAndAccountId(payeeDetailsRequest.getUserId(),
				payeeDetailsRequest.getAccountNo(), pagination);
		return payeeDetails.stream().map(data -> {
			PayeeResponse response = new PayeeResponse();
			response.setAccountNo(data.getAccountNo());
			response.setPayeeAccountNo(data.getPayeeAccountNo());
			response.setUserId(data.getUserId());
			response.setPayeeName(data.getPayeeName());
			response.setBankName("Sample");
			return response;
		}).collect(Collectors.toList());
	}

	@Override
	public Payee modifyFavPayeeDetails(Payee payee) {
		return payeeRepository.modifyFavPayeeDetails(payee.getPayeeName(), payee.getPayeeAccountNo(),
				payee.getAccountNo());
	}

	@Override
	public Payee deleteFavPayeeDetails(Payee payee) {
		// TODO Auto-generated method stub
		return payeeRepository.deleteFavPayeeDetails(payee.getUserId(), payee.getAccountNo(),
				payee.getPayeeAccountNo());
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
