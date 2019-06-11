package com.woniuxy.h_sort;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

public class User implements Serializable {
	private Integer id;
	private String name;
	private Date birthday;
	private Double money;
	private Set<String> addresses = new TreeSet<>(); 
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	public Set<String> getAddresses() {
		return addresses;
	}
	public void setAddresses(Set<String> addresses) {
		this.addresses = addresses;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthday=" + birthday + ", money=" + money + "]";
	}
}
