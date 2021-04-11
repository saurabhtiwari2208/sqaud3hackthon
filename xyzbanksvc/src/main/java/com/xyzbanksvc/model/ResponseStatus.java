package com.xyzbanksvc.model;

import lombok.Data;
import lombok.Getter;

@Data
public class ResponseStatus {
    
    String statusCode;

    String message;

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
    
    
}
