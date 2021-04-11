package com.xyzbanksvc.controller;

import com.xyzbanksvc.constants.ServiceConstants;
import com.xyzbanksvc.model.ResponseStatus;
import com.xyzbanksvc.model.User;
import com.xyzbanksvc.service.LoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    
    @Autowired
    LoginService loginService;

    @PostMapping
    public ResponseEntity userLogin(@RequestBody User user)
    {
        ResponseStatus response = loginService.authenticateUser(user);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
