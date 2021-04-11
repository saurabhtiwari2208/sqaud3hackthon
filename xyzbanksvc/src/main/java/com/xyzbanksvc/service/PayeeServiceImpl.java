package com.xyzbanksvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.xyzbanksvc.model.Payee;
import com.xyzbanksvc.repository.PayeeRepository;

public class PayeeServiceImpl implements PayeeService {

	@Autowired
	private PayeeRepository payeeRepository;

	@Override
	public List<Payee> fetchFavPayeeDetails() {
		return null;
	}

}
