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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<PlayerDTOShallow> getPlayers() {
		return players;
	}
	public void setPlayers(List<PlayerDTOShallow> players) {
		this.players = players;
	}

}
