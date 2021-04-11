package com.xyzbanksvc.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ServicePropertiesConfig {
    
    @Value("authcreds.username")
    private String basicAuthUsername;

    @Value("authcreds.password")
    private String basicAuthPassword;

    public String getBasicAuthUsername()
    {
        return basicAuthUsername;
    }
    public String getBasicAuthPassword()
    {
        return basicAuthPassword;
    }
    
}
