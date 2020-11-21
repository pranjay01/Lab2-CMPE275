package com.cmpe275.GameApp.Service;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class PlayerDTODeep {

	private Long id;
	private String firstname;
	private String lastname;
	private String email;
	private String description;
	private SponsorDTOShallow sponsor;
	private List<PlayerDTOShallow> opponents;
	
	
	/** 
	 * Getter for the Player Id
	 * @return Long
	 */
	public Long getId() {
		return id;
	}
	
	/** 
	 * Setter for the Player Id
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/** 
	 * Getter for the Player FirstName
	 * @return String
	 */
	public String getFirstname() {
		return firstname;
	}
	
	/** 
	 * Setter for the Player FirstName
	 * @param firstname
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	/** 
	 * Getter for the Player LastName
	 * @return String
	 */
	public String getLastname() {
		return lastname;
	}
	
	/** 
	 * Setter for the Player LastName
	 * @param lastname
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	/** 
	 * Getter for the Player Email
	 * @return String
	 */
	public String getEmail() {
		return email;
	}
	
	/** 
	 * Setter for the Player email
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/** 
	 * Getter for the Player Description
	 * @return String
	 */
	public String getDescription() {
		return description;
	}
	
	/** 
	 * Setter for the player Description
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/** 
	 * Get the Shallow Copy of the Sponsor Object
	 * @return SponsorDTOShallow
	 */
	public SponsorDTOShallow getSponsor() {
		return sponsor;
	}
	
	/** 
	 * Set the Sponsor for the player
	 * @param sponsor
	 */
	public void setSponsor(SponsorDTOShallow sponsor) {
		this.sponsor = sponsor;
	}
	
	/** 
	 * Get the Shallow copy List of the Opponents
	 * @return List<PlayerDTOShallow>
	 */
	public List<PlayerDTOShallow> getOpponents() {
		return opponents;
	}
	
	/** 
	 * Set the Opponent list for the Player
	 * @param opponents
	 */
	public void setOpponents(List<PlayerDTOShallow> opponents) {
		this.opponents = opponents;
	}
}
