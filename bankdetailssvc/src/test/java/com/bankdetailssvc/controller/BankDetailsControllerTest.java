package com.bankdetailssvc.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bankdetailssvc.entity.BankDetailsEntity;
import com.bankdetailssvc.repository.BankDetailsRepository;

@ExtendWith(MockitoExtension.class)
public class BankDetailsControllerTest {

	@BeforeEach
	public void setup() {
		Mockito.when(bankDetailsRepository.findByBankCode(Mockito.anyString())).thenReturn(new BankDetailsEntity("1234","ABC Bank"));
	}

	@InjectMocks
	private BankDetailsController bankDetailsController;

	@Mock
	private BankDetailsRepository bankDetailsRepository;

//	@BeforeEach
//	public void setup() {
//		
//	}

	@Test
	public void testController() {
		BankDetailsEntity result = bankDetailsController.fetchBankDetails("1234");
		Assertions.assertEquals("ABC Bank", result.getBankName());
		Assertions.assertEquals("1234", result.getBankCode());
	}
}
