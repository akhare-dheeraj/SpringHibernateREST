package com.demo.beans;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Subject implements BaseBean{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7442686203621815611L;

	@Id
	@GeneratedValue
	private int subId;
	
	@Column
	private String subName;
	
	@Column
	private String author;

	public Subject() {
	}

	public Subject(String subName, String author) {
		super();
		this.subName = subName;
		this.author = author;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + subId;
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
		Subject other = (Subject) obj;
		if (subId != other.subId)
			return false;
		return true;
	}

	public int getSubId() {
		return subId;
	}
	
	public void setSubId(int subId) {
		this.subId = subId;
	}

	public String getSubName() {
		return subName;
	}

	public void setSubName(String subName) {
		this.subName = subName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
}
