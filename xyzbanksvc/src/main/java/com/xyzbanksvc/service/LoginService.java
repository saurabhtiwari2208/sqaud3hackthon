package com.xyzbanksvc.service;

import java.util.Optional;

import com.xyzbanksvc.constants.ServiceConstants;
import com.xyzbanksvc.model.ResponseStatus;
import com.xyzbanksvc.model.User;
import com.xyzbanksvc.repository.UserRepository;
import com.xyzbanksvc.util.ShaUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * LoginService
 */
@Service
public class LoginService {

    @Autowired
    UserRepository userRepo;

    @Autowired
    ShaUtils shaUtils;

    public ResponseStatus authenticateUser(User user)
    {
        String status = "";
        ResponseStatus responseStatus = new ResponseStatus();
        responseStatus.setStatusCode(ServiceConstants.FAILURE_STATUS_CODE);
        responseStatus.setMessage(ServiceConstants.AUTH_FAILURE_MESSAGE);
        Optional<User> fetchedUser = userRepo.findById(user.getUserId());
        if(fetchedUser.isPresent())
        {
            String encodedPassword = shaUtils.digest(user.getPassword(), ServiceConstants.ENCODING_ALGO);
            if(fetchedUser.get().getPassword().equals(encodedPassword))
            {
                responseStatus.setStatusCode(ServiceConstants.SUCCESS_STATUS_CODE);
                responseStatus.setMessage(ServiceConstants.AUTH_SUCCESS_MESSAGE);
            }
        }
        return responseStatus;
    }

    // public static void main(String[] args) {
    //     PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
    //     System.out.println(encoder.encode("user123"));
    // }
}