package com.woniuxy.c_hbm;

import java.io.Serializable;

public class Car implements Serializable {
	
	private String cid;
	private String brand;
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	@Override
	public String toString() {
		return "Car [cid=" + cid + ", brand=" + brand + "]";
	}

}
