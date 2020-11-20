package com.cmpe275.GameApp.Entity;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonInclude (Include.NON_NULL)
@Entity
@Table (name="SPONSOR")
public class Sponsor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
    private String name;
	private String description;
	
	@Embedded
	@AttributeOverrides({
  	@AttributeOverride( name = "street", column = @Column(name = "street")),
  	@AttributeOverride( name = "city", column = @Column(name = "city")),
  	@AttributeOverride( name = "state", column = @Column(name = "state")),
  	@AttributeOverride( name = "zip", column = @Column(name = "zip"))
	})
	private Address address;
	
	@OneToMany(mappedBy = "sponsor")
	@LazyCollection(LazyCollectionOption.TRUE)
	private List<Player> players;
	
	public Sponsor() {
	}
	
	public Sponsor(String name, String description, Address address) {
		super();
		this.name = name;
		this.description = description;
		this.address = address;
	}
	
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
	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	

}