package edu.mum.company.entity;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotEmpty;

/**
 * @author: ChauKy
 * @Date: Apr 20, 2018
 */

@Embeddable
public class Address {
	@NotEmpty
	private String street;
	@NotEmpty
	private String city;
	@NotEmpty
	private String state;
	@NotEmpty
	private String country;
	@NotEmpty
	private int zipcode;
	
	
	public Address() {
	}

	public String getStreet() {
		return street;
	}
	
	public void setStreet(String street) {
		this.street = street;
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
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public int getZipcode() {
		return zipcode;
	}
	
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	@Override
	public String toString() {
		return "Address [street=" + street + ", state=" + state + ", country=" + country + ", zipcode=" + zipcode + "]";
	}
	
	
}
