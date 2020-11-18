package com.cmpe275.GameApp.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name="PLAYER")
public class Player {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name="firstname")
    private String firstname;
	@Column(name="lastname")
    private String lastname;
	@Column(name="email")
    private String email;
	@Column(name="description")
	private String description;
	@Column(name = "sponsorid")
	private Long sponsorId;

 
	// @ManyToOne(cascade = CascadeType.ALL)
	// @JoinColumn(name = "sponsorid", referencedColumnName = "id")
	// private Long sponsorId;
	// private Sponsor sponsor;
   	// private List<Player> opponents;
	public Player() {
	}
	
	public Player(String firstname, String lastname, String email, String description, Long sponsorId) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.description = description;
		this.sponsorId = sponsorId;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	
	public long getSponsorId() {
		return sponsorId;
	}
	public void setSponsorId(long sponsorId) {
		this.sponsorId = sponsorId;
	}
//	public List<Player> getOpponents() {
//		return opponents;
//	}
//	public void setOpponents(List<Player> opponents) {
//		this.opponents = opponents;
//	}

	

	// public Sponsor getSponsor() {
	// 	return sponsor;
	// }

	// public void setSponsor(Sponsor sponsor) {
	// 	this.sponsor = sponsor;
	// }
    
}
