package com.xyzbanksvc.configuration;

import javax.annotation.PostConstruct;

import com.xyzbanksvc.model.User;
import com.xyzbanksvc.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class BeanConfig {
    
    @Autowired
    UserRepository userRepo;

    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @PostConstruct
    public void loadUserCreds()
    {
        User user = new User();
        for(int i= 0; i < 10; i++)
        {
            user.setUserId("user"+i);
            user.setPassword(passwordEncoder().encode("user"+i+"@123"));
            userRepo.save(user);
        }
    }
}
