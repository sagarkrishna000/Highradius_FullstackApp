package com.highradius.model;
public class Invoice {
	private Integer SlNo;
	private Integer CustomerOrderId;
	private Integer SalesOrg;
	private String DistributionChannel;
	private Integer CompanyCode;
	private String OrderCreationDate;
	private String OrderCurrency;
	private Integer CustomerNo ;
	private Double AmountInUsd;
	private Double OrderAmount;
	public Invoice()
	{
		
	}
	public Invoice(Integer SlNo,Integer CustomerOrderId,Integer SalesOrg,String DistributionChannel,Integer CompanyCode,String OrderCreationDate,String OrderCurrency,Integer CustomerNo,Double AmountInUsd,Double OrderAmount)
	{
		this.SlNo = SlNo;
		this.CustomerOrderId = CustomerOrderId;
		this.SalesOrg = SalesOrg;
		this.DistributionChannel = DistributionChannel;
		this.CompanyCode = CompanyCode;
		this.OrderCreationDate = OrderCreationDate;
		this.OrderCurrency = OrderCurrency;
		this.CustomerNo = CustomerNo;
		this.AmountInUsd = AmountInUsd;
		this.OrderAmount = OrderAmount;
	}
	public Integer getSlNo() {
		return SlNo;
	}
	public void setSlNo(Integer slNo) {
		SlNo = slNo;
	}
	public Integer getCustomerOrderId() {
		return CustomerOrderId;
	}
	public void setCustomerOrderId(Integer customerOrderId) {
		CustomerOrderId = customerOrderId;
	}
	public Integer getSalesOrg() {
		return SalesOrg;
	}
	public void setSalesOrg(Integer salesOrg) {
		SalesOrg = salesOrg;
	}
	public String getDistributionChannel() {
		return DistributionChannel;
	}
	public void setDistributionChannel(String distributionChannel) {
		DistributionChannel = distributionChannel;
	}
	public Integer getCompanyCode() {
		return CompanyCode;
	}
	public void setCompanyCode(Integer companyCode) {
		CompanyCode = companyCode;
	}
	public String getOrderCreationDate() {
		return OrderCreationDate;
	}
	public void setOrderCreationDate(String orderCreationDate) {
		OrderCreationDate = orderCreationDate;
	}
	public String getOrderCurrency() {
		return OrderCurrency;
	}
	public void setOrderCurrency(String orderCurrency) {
		OrderCurrency = orderCurrency;
	}
	public Integer getCustomerNo() {
		return CustomerNo;
	}
	public void setCustomerNo(Integer customerNo) {
		CustomerNo = customerNo;
	}
	public Double getAmountInUsd() {
		return AmountInUsd;
	}
	public void setAmountInUsd(Double amountInUsd) {
		AmountInUsd = amountInUsd;
	}
	public Double getOrderAmount() {
		return OrderAmount;
	}
	public void setOrderAmount(Double orderAmount) {
		OrderAmount = orderAmount;
	}
	@Override
	public String toString() {
		return Integer.toString(SlNo) +','+ Integer.toString(CustomerOrderId) +','+ Integer.toString(SalesOrg) +','+ DistributionChannel+','+OrderCurrency+','+OrderCreationDate+','+Integer.toString(CustomerNo)+','+Double.toString(AmountInUsd)+','+Double.toString(OrderAmount);
	}
}
