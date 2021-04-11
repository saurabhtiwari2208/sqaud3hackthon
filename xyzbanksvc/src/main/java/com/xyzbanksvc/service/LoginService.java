package com.xyzbanksvc.service;

import com.xyzbanksvc.constants.ServiceConstants;
import com.xyzbanksvc.model.ResponseStatus;
import com.xyzbanksvc.model.User;

import org.springframework.stereotype.Service;

/**
 * LoginService
 */
@Service
public class LoginService {

    public ResponseStatus authenticateUser(User user)
    {
        String status = "";
        ResponseStatus responseStatus = new ResponseStatus();
        responseStatus.setStatusCode(ServiceConstants.FAILURE_STATUS_CODE);
        responseStatus.setMessage(ServiceConstants.AUTH_FAILURE_MESSAGE);

        if(status.equals(ServiceConstants.SUCCESS_STATUS_CODE))
        {
            responseStatus.setStatusCode(ServiceConstants.SUCCESS_STATUS_CODE);
            responseStatus.setMessage(ServiceConstants.AUTH_SUCCESS_MESSAGE);
        }
        return responseStatus;
    }
}