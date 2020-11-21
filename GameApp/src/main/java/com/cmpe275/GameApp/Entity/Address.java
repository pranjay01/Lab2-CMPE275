package com.cmpe275.GameApp.Entity;

import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Embeddable
@JsonInclude (Include.NON_NULL)
public class Address {

	private String street;
	private String city;
	private String state;
	private String zip;

	public Address() {
	}
	public Address(String street, String city, String state, String zip) {
		super();
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	
	/** 
	 * Getter for the Address Street
	 * @return String
	 */
	public String getStreet() {
		return street;
	}
	
	/** 
	 * Setter for the Address Street
	 * @param street
	 */
	public void setStreet(String street) {
		this.street = street;
	}
	
	/** 
	 * Getter for the Address City
	 * @return String
	 */
	public String getCity() {
		return city;
	}
	
	/** 
	 * Setter for the address City
	 * @param city
	 */
	public void setCity(String city) {
		this.city = city;
	}
	
	/** 
	 * Getter for the address State
	 * @return String
	 */
	public String getState() {
		return state;
	}
	
	/** 
	 * Setter for the Address State
	 * @param state
	 */
	public void setState(String state) {
		this.state = state;
	}
	
	/** 
	 * Getter for the Address Zip Code
	 * @return String
	 */
	public String getZip() {
		return zip;
	}
	
	/** 
	 * Setter for the address Zip code
	 * @param zip
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}


}
