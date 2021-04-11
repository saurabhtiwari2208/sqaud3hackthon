package com.xyzbanksvc;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.xyzbanksvc.model.Payee;
import com.xyzbanksvc.model.User;
import com.xyzbanksvc.repository.PayeeRepository;
import com.xyzbanksvc.repository.UserRepository;
import com.xyzbanksvc.service.LoginService;
import com.xyzbanksvc.service.PayeeServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class LoginServiceTest {

	@Mock
	PayeeRepository payeeRepository;

	@InjectMocks
	UserRepository userRepo;
	
	
	@Test
	public void authenticateUser() {
		
		User user = new User();
		user.setUserId("xyz");
		user.setPassword("123");
		Optional<User> fetchedUser = Optional.of(user);
	
		
		when(userRepo.findById(user.getUserId())).thenReturn(fetchedUser);
		
		Optional<User> userRet = userRepo.findById(user.getUserId());
		
		assertEquals(userRet, fetchedUser);
		
	}
	
	
}
