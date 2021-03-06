package com.xyzbanksvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.xyzbanksvc.constants.ServiceConstants;
import com.xyzbanksvc.model.Payee;
import com.xyzbanksvc.model.ResponseStatus;
import com.xyzbanksvc.model.User;
import com.xyzbanksvc.model.PayeeDetailsRequest;
import com.xyzbanksvc.model.PayeeResponse;
import com.xyzbanksvc.service.PayeeService;

@RestController
public class PayeeController {

	@Autowired
	private PayeeService payeeService;

	@PutMapping(value = "/modifyFavPayeeDetails", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Object> updateFavPayeeDetails(@RequestBody Payee payee) {

		ResponseEntity<Object> resp = null;	
		ResponseStatus responseStatus = new ResponseStatus();
		
		int records = payeeService.modifyFavPayeeDetails(payee);
		if(records > 0 ) {
			responseStatus.setStatusCode(ServiceConstants.SUCCESS_STATUS_CODE);
            responseStatus.setMessage(ServiceConstants.FAV_PAYEE_UPDATED);
			resp = new ResponseEntity<Object>(responseStatus, HttpStatus.OK);
		}else {
			responseStatus.setStatusCode(ServiceConstants.FAILURE_STATUS_CODE);
            responseStatus.setMessage(ServiceConstants.FAV_PAYEE_UPDATE_FAILED);
			resp = new ResponseEntity<Object>(responseStatus, HttpStatus.OK);
		}
	

		return resp;
	}
	
	@DeleteMapping(value = "/delFavPayeeDetails", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Object> delFavPayeeDetails(@RequestBody Payee payee) {

		ResponseEntity<Object> resp = null;	
		ResponseStatus responseStatus = new ResponseStatus();
		
		int records = payeeService.deleteFavPayeeDetails(payee);
		if(records > 0) {
			responseStatus.setStatusCode(ServiceConstants.SUCCESS_STATUS_CODE);
            responseStatus.setMessage(ServiceConstants.FAV_PAYEE_DELETED);
			resp = new ResponseEntity<Object>(responseStatus, HttpStatus.OK);
		}else {
			responseStatus.setStatusCode(ServiceConstants.FAILURE_STATUS_CODE);
            responseStatus.setMessage(ServiceConstants.FAV_PAYEE_DELETE_FAILED);
			resp = new ResponseEntity<Object>(responseStatus, HttpStatus.OK);
		}


		return resp;
	}

	@PostMapping("/fetchFavPayeeDetails")
	@ResponseBody
	public List<PayeeResponse> fetchPayeeDetails(@RequestBody PayeeDetailsRequest payeeDetailsRequest) {
		return payeeService.fetchFavPayeeDetails(payeeDetailsRequest);
	}

	@PostMapping("/addFavPayeeDetails")
	@ResponseBody
	public ResponseEntity<String> addFavPayeeDetails(@RequestBody Payee payee) {
		String message = payeeService.addPayeeDetails(payee);
		return new ResponseEntity<>(message, HttpStatus.OK);
	}
}
