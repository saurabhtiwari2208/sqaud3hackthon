package com.xyzbanksvc;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.xyzbanksvc.model.Payee;
import com.xyzbanksvc.repository.PayeeRepository;

@RunWith(MockitoJUnitRunner.class)
public class PayeeServiceImplTest {

	@Mock
	PayeeRepository payeeRepository;

	

	@Test
	public void modifyFavPayeeDetailsTest() {
		
		Payee payee = new Payee();
		payee.setAccountNo("1234");
		payee.setPayeeAccountNo(null);
		
		payee.setPayeeName("Fav Payee Test"); 
		payee.setPayeeAccountNo("TESTACC001");
		payee.setAccountNo("ACC001") ;
		
		int i=1;
		
		when(payeeRepository.modifyFavPayeeDetails(payee.getPayeeName(), payee.getPayeeAccountNo(),payee.getAccountNo())).thenReturn(i);
		
		int j= payeeRepository.modifyFavPayeeDetails(payee.getPayeeName(), payee.getPayeeAccountNo(),payee.getAccountNo());
		
		assertEquals(1, j);
		
	}
}
