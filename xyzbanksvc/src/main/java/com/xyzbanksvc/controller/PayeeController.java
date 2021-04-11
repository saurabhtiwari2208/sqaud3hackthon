package com.xyzbanksvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.xyzbanksvc.model.Payee;
import com.xyzbanksvc.model.PayeeDetailsRequest;
import com.xyzbanksvc.service.PayeeService;

@RestController
public class PayeeController {

	@Autowired
	private PayeeService payeeService;

	@PutMapping(value = "/modifyFavPayeeDetails", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Object> updateUser(@RequestBody Payee payee) {

		ResponseEntity<Object> resp = null;

		payeeService.modifyFavPayeeDetails(payee);

		return resp;
	}

	@PostMapping("/fetchFavPayeeDetails")
	@ResponseBody
	public List<Payee> saveUser(@RequestBody PayeeDetailsRequest payeeDetailsRequest) {
		return payeeService.fetchFavPayeeDetails(payeeDetailsRequest);
	}

}
