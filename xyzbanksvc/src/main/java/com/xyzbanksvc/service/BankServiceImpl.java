package com.xyzbanksvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.xyzbanksvc.configuration.ServicePropertiesConfig;
import com.xyzbanksvc.model.BankDetailsEntity;

@Service
public class BankServiceImpl implements BankService {

	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private ServicePropertiesConfig config;

	@Override
	public BankDetailsEntity getBankDetails(String bankCode) {
		HttpHeaders headers = new HttpHeaders();
		headers.setBasicAuth(config.getBasicAuthUsername(), config.getBasicAuthPassword());
		HttpEntity entity = new HttpEntity<>(headers);
		return restTemplate.exchange("http://localhost:8081/fetchBankDetails/{bankCode}", HttpMethod.GET, entity,
				BankDetailsEntity.class, bankCode).getBody();
	}
}
