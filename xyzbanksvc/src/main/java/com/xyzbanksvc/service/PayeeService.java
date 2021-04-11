package com.xyzbanksvc.service;

import java.util.List;

import com.xyzbanksvc.model.Payee;

/**
 * Payee Service for accessing the data from Payee Repository.
 * 
 * @author Steny Adams J
 *
 */
public interface PayeeService {

	List<Payee> fetchFavPayeeDetails();
}
