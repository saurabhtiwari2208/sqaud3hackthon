package com.xyzbanksvc.service;

import java.util.Optional;

import com.xyzbanksvc.constants.ServiceConstants;
import com.xyzbanksvc.model.ResponseStatus;
import com.xyzbanksvc.model.User;
import com.xyzbanksvc.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * LoginService
 */
@Service
public class LoginService {

    @Autowired
    UserRepository userRepo;

    public ResponseStatus authenticateUser(User user)
    {
        String status = "";
        ResponseStatus responseStatus = new ResponseStatus();
        responseStatus.setStatusCode(ServiceConstants.FAILURE_STATUS_CODE);
        responseStatus.setMessage(ServiceConstants.AUTH_FAILURE_MESSAGE);
        Optional<User> fetchedUser = userRepo.findById(user.getUserId());
        if(fetchedUser.isPresent())
        {
            PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
            String encodedPassword = encoder.encode(user.getPassword());
            if(fetchedUser.get().getPassword().equals(encodedPassword))
            {
                responseStatus.setStatusCode(ServiceConstants.SUCCESS_STATUS_CODE);
                responseStatus.setMessage(ServiceConstants.AUTH_SUCCESS_MESSAGE);
            }
        }
        return responseStatus;
    }
}