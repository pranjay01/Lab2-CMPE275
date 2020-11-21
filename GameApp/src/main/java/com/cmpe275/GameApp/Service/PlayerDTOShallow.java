package com.cmpe275.GameApp.Service;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class PlayerDTOShallow {
	
	private Long id;
	private String firstname;
	private String lastname;
	private String email;
	private String description;
	
	/** getter for the player Id
	 * @return Long
	 */
	public Long getId() {
		return id;
	}
	
	/** 
	 * Setter Player Id
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/** 
	 * Getter for Player Firstname
	 * @return String
	 */
	public String getFirstname() {
		return firstname;
	}
	
	/** 
	 * Setter for Player Firstname
	 * @param firstname
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	/** 
	 * Getter for Player Lastname
	 * @return String
	 */
	public String getLastname() {
		return lastname;
	}
	
	/** 
	 * Setter for Player Lastname
	 * @param lastname
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	/** 
	 * Player Email Getter
	 * @return String
	 */
	public String getEmail() {
		return email;
	}
	
	/** 
	 * Player Email Setter
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
	 * Setter for the Player Description
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
}
