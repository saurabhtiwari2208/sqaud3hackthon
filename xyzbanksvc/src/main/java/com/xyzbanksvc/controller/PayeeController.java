package com.xyzbanksvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.xyzbanksvc.constants.ServiceConstants;
import com.xyzbanksvc.model.Payee;
import com.xyzbanksvc.model.ResponseStatus;
import com.xyzbanksvc.service.PayeeService;




@Controller
public class PayeeController {

	@Autowired
	PayeeService payeeService;
	
	@PutMapping(value = "/modifyFavPayeeDetails", 
			consumes = { MediaType.APPLICATION_JSON_VALUE },
			produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Object> updateUser(@RequestBody Payee payee) {

		ResponseEntity<Object> resp = null;
		
		ResponseStatus responseStatus = new ResponseStatus();
		
		Payee payeeResp = payeeService.modifyFavPayeeDetails(payee);
		if(payeeResp!=null) {
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

}
