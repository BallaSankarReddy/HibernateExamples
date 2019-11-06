package com.flipkart.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Table
@Entity
@XmlRootElement(name = "Customer")

public class Customer implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column
	private Integer customerId;
	@Column
	private String customerName;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="customer")
	private List<Electronics> electronics;
	
	
	public List<Electronics> getElectronics() {
		return electronics;
	}

	public void setElectronics(List<Electronics> electronics) {
		this.electronics = electronics;
	}

	public Customer() {
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

}
