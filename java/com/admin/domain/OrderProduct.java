package com.admin.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "orderProduct")
@Table(name = "orderProduct")
public class OrderProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Date orderDate;

	@Column(name = "orderStatus", updatable = true)
	private String orderStatus;

	private BigDecimal orderTotal;
	private String shippingMethod;

	@OneToMany(mappedBy = "orderProduct", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<LineProduct> lineProductList;

	@OneToOne(cascade = CascadeType.ALL)
	private PaymentOrderMethod paymentOrderMethod;

	@OneToOne(cascade = CascadeType.ALL)
	private AddressOrder addressOrder;

	@ManyToOne
	private User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AddressOrder getAddressOrder() {
		return addressOrder;
	}

	public void setAddressOrder(AddressOrder addressOrder) {
		this.addressOrder = addressOrder;
	}

	public List<LineProduct> getLineProductList() {
		return lineProductList;
	}

	public void setLineProductList(List<LineProduct> lineProductList) {
		this.lineProductList = lineProductList;
	}

	public PaymentOrderMethod getPaymentOrderMethod() {
		return paymentOrderMethod;
	}

	public void setPaymentOrderMethod(PaymentOrderMethod paymentOrderMethod) {
		this.paymentOrderMethod = paymentOrderMethod;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public BigDecimal getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(BigDecimal orderTotal) {
		this.orderTotal = orderTotal;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getShippingMethod() {
		return shippingMethod;
	}

	public void setShippingMethod(String shippingMethod) {
		this.shippingMethod = shippingMethod;
	}

}
