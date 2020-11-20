package com.cmpe275.GameApp.Entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

//@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@JsonInclude(Include.NON_NULL)
@Entity
@Table(name = "PLAYER")
public class Player {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "firstname")
	private String firstname;
	@Column(name = "lastname")
	private String lastname;
	@Column(name = "email")
	private String email;
	@Column(name = "description")
	private String description;

	@ManyToOne(fetch = FetchType.LAZY)
	@LazyToOne(LazyToOneOption.NO_PROXY)
	@JoinColumn(name = "sponsorid")
	private Sponsor sponsor;

	// @Transient
	@ManyToMany(fetch = FetchType.LAZY)
	@LazyCollection(LazyCollectionOption.TRUE)
	@JoinTable(name = "OPPONENTS", joinColumns = @JoinColumn(name = "player1"), inverseJoinColumns = @JoinColumn(name = "player2"))
	private List<Player> opponents;

	// @ManyToMany(mappedBy="opponents")
	// private List<Player> opponenttwo;

	// @ManyToOne(cascade = CascadeType.ALL)
	// @JoinColumn(name = "sponsorid", referencedColumnName = "id")
	// private Long sponsorId;
	// private Sponsor sponsor;
	// private List<Player> opponents;
	
	public Player() {

	}

	public Player(String firstname, String lastname, String email, String description, Sponsor sponsor) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.description = description;
		this.sponsor = sponsor;
	}
	
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

	public List<Player> getOpponents() {
		return opponents;
	}

	public void setOpponents(List<Player> opponents) {
		this.opponents = opponents;
	}

	public Sponsor getSponsor() {
		return sponsor;
	}

	public void setSponsor(Sponsor sponsor) {
		this.sponsor = sponsor;
	}

	

}