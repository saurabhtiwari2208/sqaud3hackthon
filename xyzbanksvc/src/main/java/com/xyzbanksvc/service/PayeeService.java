package com.xyzbanksvc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.xyzbanksvc.model.Payee;
import com.xyzbanksvc.model.PayeeDetailsRequest;
import com.xyzbanksvc.model.PayeeResponse;

/**
 * Payee Service for accessing the data from Payee Repository.
 * 
 * @author Steny Adams J
 *
 */
@Service
public interface PayeeService {

	List<PayeeResponse> fetchFavPayeeDetails(PayeeDetailsRequest payeeDetailsRequest);

	int modifyFavPayeeDetails(Payee payee);

	int deleteFavPayeeDetails(Payee payee);

	String addPayeeDetails(Payee payee);
}
