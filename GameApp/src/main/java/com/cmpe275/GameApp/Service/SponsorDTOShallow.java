package com.cmpe275.GameApp.Service;

import com.cmpe275.GameApp.Entity.Address;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class SponsorDTOShallow {

	private Long id;
    private String name;
	private String description;
	private Address address;
	
	/** 
	 * Get the Id of the Sponsor
	 * @return Long Id of the Sponsor
	 */
	public Long getId() {
		return id;
	}
	
	/** 
	 * Set the Sponsor's Id
	 * @param id Sponsor's Id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/** 
	 * get the Name of the Sponsor
	 * @return String name of the Sponsor
	 */
	public String getName() {
		return name;
	}
	
	/** 
	 * Set the name of the Sponsor
	 * @param name name of the Sponsor
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/** 
	 * Get the Description of the Sponsor
	 * @return String
	 */
	public String getDescription() {
		return description;
	}
	
	/** 
	 * Set the Description of the Sponsor
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/** 
	 * Get the Address of the Sponsor
	 * @return Address
	 */
	public Address getAddress() {
		return address;
	}
	
	/** 
	 * Set the new Address of the Sponsor
	 * @param address
	 */
	public void setAddress(Address address) {
		this.address = address;
	}
	
}
