package com.demo.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "ADDRESS")
@XmlRootElement(name = "address")
public class Address implements BaseBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4305462688140669949L;

	@Id
	@GeneratedValue
	@XmlElement(name = "id")
	private int addrId;
	
	@Column(name = "city")
	@XmlElement(name = "city")
	private String city;
	
	@Column(name = "state")
	@XmlElement(name = "state")
	private String state;

	public Address(String city, String state) {
		super();
		this.city = city;
		this.state = state;
	}

	public Address() {
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + addrId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (addrId != other.addrId)
			return false;
		return true;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}
