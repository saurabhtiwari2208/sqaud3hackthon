package com.xyzbanksvc.configuration;

import javax.annotation.PostConstruct;

import com.xyzbanksvc.constants.ServiceConstants;
import com.xyzbanksvc.model.User;
import com.xyzbanksvc.repository.UserRepository;
import com.xyzbanksvc.util.ShaUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeanConfig {

	@Autowired
	UserRepository userRepo;

	@Autowired
	ShaUtils shaUtils;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@PostConstruct
	public void loadUserCreds() {
		User user = new User();
		for (int i = 0; i < 10; i++) {
			user.setUserId("user" + i);
			user.setPassword(shaUtils.digest("user" + i + "@123", ServiceConstants.ENCODING_ALGO));
			userRepo.save(user);
		}
	}

	// public static void main(String[] args) {
	// ShaUtils shaUtils = new ShaUtils();
	// shaUtils.digest("user"+"1"+"@123", "SHA3-256");
	// System.out.println(shaUtils.digest("user"+"1"+"@123", "SHA3-256"));
	// }
}
