package com.gy.bean;

public class Location {
	
	private Integer id;
	
	private String addressStreet;
	
	private String city;

	public Location() {
		super();
	}

	public Location(Integer id, String addressStreet, String city) {
		super();
		this.id = id;
		this.addressStreet = addressStreet;
		this.city = city;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAddressStreet() {
		return addressStreet;
	}

	public void setAddressStreet(String addressStreet) {
		this.addressStreet = addressStreet;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Location [id=" + id + ", addressStreet=" + addressStreet + ", city=" + city + "]";
	}
	
}
