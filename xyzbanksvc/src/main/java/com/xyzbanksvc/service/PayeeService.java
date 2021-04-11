package com.xyzbanksvc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.xyzbanksvc.model.Payee;
import com.xyzbanksvc.model.PayeeDetailsRequest;

/**
 * Payee Service for accessing the data from Payee Repository.
 * 
 * @author Steny Adams J
 *
 */
@Service
public interface PayeeService {

	List<Payee> fetchFavPayeeDetails(PayeeDetailsRequest payeeDetailsRequest);

	Payee modifyFavPayeeDetails(Payee payee);

	String addPayeeDetails(Payee payee);
}
