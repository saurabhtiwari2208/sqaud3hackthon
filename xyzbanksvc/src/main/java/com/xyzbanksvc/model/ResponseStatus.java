package com.xyzbanksvc.model;

import lombok.Data;
import lombok.Getter;

@Data
public class ResponseStatus {
    
    String statusCode;

    String message;
}
