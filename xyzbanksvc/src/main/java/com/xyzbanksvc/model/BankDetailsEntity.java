package com.xyzbanksvc.model;

public class BankDetailsEntity {

	private String bankCode;

	private String bankName;

	public String getBankCode() {
		return this.bankCode;
	}

	public String getBankName() {
		return this.bankName;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public BankDetailsEntity(String bankCode, String bankName) {
		this.bankCode = bankCode;
		this.bankName = bankName;
	}

	public BankDetailsEntity() {
		this.bankCode = null;
		this.bankName = null;
	}

}
