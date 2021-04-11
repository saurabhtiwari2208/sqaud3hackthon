package com.bankdetailssvc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BankDetails")
// @Data
// @AllArgsConstructor
// @NoArgsConstructor
public class BankDetailsEntity {

	@Column(name = "bank_code")
	@Id
	private String bankCode = "";

	@Column(name = "bank_name")
	private String bankName = "";

	public String getBankCode()
	{
		return this.bankCode;
	}

	public String getBankName()
	{
		return this.bankName;
	}

	public void setBankCode(String bankCode)
	{
		this.bankCode = bankCode;
	}

	public void setBankName(String bankName)
	{
		this.bankName = bankName;
	}

	public BankDetailsEntity(String bankCode, String bankName)
	{
		this.bankCode = bankCode;
		this.bankName = bankName;
	}

	public BankDetailsEntity()
	{
		this.bankCode = null;
		this.bankName = null;
	}

}
