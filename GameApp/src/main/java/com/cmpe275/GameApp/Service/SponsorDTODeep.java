package com.cmpe275.GameApp.Service;

import java.util.List;

import com.cmpe275.GameApp.Entity.Address;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class SponsorDTODeep {
	
	private Long id;
    private String name;
	private String description;
	private Address address;
	private List<PlayerDTOShallow> players;
	
	/** 
	 * Get Sponsor Id
	 * @return Long
	 */
	public Long getId() {
		return id;
	}
	
	/** 
	 * Set Sponsor Id
	 * @param id Sponsor Id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/** 
	 * Get Sponsor name
	 * @return String Sponsor name
	 */
	public String getName() {
		return name;
	}
	
	/** 
	 * Set Sponsor name
	 * @param name name of the Sponsor
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/** 
	 * Get Sponsor Description
	 * @return String Sponsor Description
	 */
	public String getDescription() {
		return description;
	}
	
	/** 
	 * Set sponsor Description
	 * @param description Description for the Sponsor
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/** 
	 * Get Sponsor Address
	 * @return Address Sponsor's Address
	 */
	public Address getAddress() {
		return address;
	}
	
	/** 
	 * Set Address Sponsor
	 * @param address Address of the Sponsor
	 */
	public void setAddress(Address address) {
		this.address = address;
	}
	
	/** 
	 * Get List of the Player for the Sponsor
	 * @return List<PlayerDTOShallow> Player Shallow Object List
	 */
	public List<PlayerDTOShallow> getPlayers() {
		return players;
	}
	
	/** 
	 * Set Players List for the sponsor
	 * @param players New Players List
	 */
	public void setPlayers(List<PlayerDTOShallow> players) {
		this.players = players;
	}

}
