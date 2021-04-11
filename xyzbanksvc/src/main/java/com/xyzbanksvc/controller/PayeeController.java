package com.xyzbanksvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.xyzbanksvc.model.Payee;
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
		
		payeeService.modifyFavPayeeDetails(payee);
		
		return resp;
	}

}
