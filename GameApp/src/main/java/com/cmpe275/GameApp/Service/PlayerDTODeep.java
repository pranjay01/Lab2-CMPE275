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
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public SponsorDTOShallow getSponsor() {
		return sponsor;
	}
	public void setSponsor(SponsorDTOShallow sponsor) {
		this.sponsor = sponsor;
	}
	public List<PlayerDTOShallow> getOpponents() {
		return opponents;
	}
	public void setOpponents(List<PlayerDTOShallow> opponents) {
		this.opponents = opponents;
	}
}
