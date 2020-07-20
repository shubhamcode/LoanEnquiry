package com.codingtest.loanportal;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EnquiryForm {

	@Id
	private int enquiryId;
	private String customerName;
	private String jobType;
	private double loanAmount;
	private double interestRate;
	public int getEnquiryId() {
		return enquiryId;
	}
	public void setEnquiryId(int enquiryId) {
		this.enquiryId = enquiryId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getJobType() {
		return jobType;
	}
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}
	public double getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}
	public double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	@Override
	public String toString() {
		return "EnquiryForm [enquiryId=" + enquiryId + ", customerName=" + customerName + ", jobType=" + jobType
				+ ", loanAmount=" + loanAmount + ", interestRate=" + interestRate + "]";
	}
	
	
	
	

	
}
