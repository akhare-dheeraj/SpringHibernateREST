package com.demo.beans;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "STUDENT")
public class Student implements BaseBean{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5287010108063226534L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int stuId;
	
	@Column(name = "NAME", nullable = false)
	private String stuName;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Address addr;
	
	@OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinColumn(name = "stuId")
	private Set<Subject> subjects;

	public Student() {
	}

	public Student(String stuName, Address addr, Set<Subject> subjects) {
		super();
		this.stuName = stuName;
		this.addr = addr;
		this.subjects = subjects;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + stuId;
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
		Student other = (Student) obj;
		if (stuId != other.stuId)
			return false;
		return true;
	}

	public int getStuId() {
		return stuId;
	}

	public void setStuId(int stuId) {
		this.stuId = stuId;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public Address getAddr() {
		return addr;
	}

	public void setAddr(Address addr) {
		this.addr = addr;
	}

	public Set<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}
}
