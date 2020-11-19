package com.cmpe275.GameApp.Controller;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cmpe275.GameApp.Entity.Address;
import com.cmpe275.GameApp.Entity.Player;
import com.cmpe275.GameApp.Entity.Sponsor;
import com.cmpe275.GameApp.Service.PlayerService;
import com.cmpe275.GameApp.Service.SponsorService;

@RestController
public class GameAppController {

	@Autowired
	PlayerService playerService;

	@Autowired
	SponsorService sponsorService;

	@PostMapping ("/player")
	public ResponseEntity<Player> createPlayer(@RequestParam(value="firstname") String firstname, 
			@RequestParam(value="lastname") String lastname,
			@RequestParam(value="email") String email,
			@RequestParam(value="description", required = false) String description,
			@RequestParam(value = "sponsorId", required = false) Long sponsorId) {

		Sponsor sponsor = null;
		if(sponsorId != null) {
			sponsor = new Sponsor();
			sponsor.setId(sponsorId);
		}
		
		Player player = new Player(firstname, lastname, email, description, sponsor);
		playerService.createPlayer(player);
		return new ResponseEntity<Player>(player, HttpStatus.OK);
	}

	@PostMapping ("/player/{id}")
	public Player updatePlayer(@RequestParam(value="firstname") String firstname, 
			@RequestParam(value="lastname") String lastname,
			@RequestParam(value="email") String email,
			@RequestParam(value="description", required = false) String description,
			@RequestParam(value = "sponsorId", required = false) Long sponsorId, @PathVariable("id") Long id) {
		
		Sponsor sponsor = null;
		if(sponsorId != null) {
			sponsor = new Sponsor();
			sponsor.setId(sponsorId);
		}
		Player player = new Player(firstname, lastname, email, description, sponsor);
		player.setId(id);
		return playerService.updatePlayer(player);
	}

	@GetMapping ("/player/{id}")
	public Player getPlayer(@PathVariable("id") Long id) {
		Player player = playerService.getPlayer(id);
		if(player == null)
			throw new EntityNotFoundException();
		return player;
	}
	
	@DeleteMapping("/player/{id}")
	public Player deletePlayer(@PathVariable("id") Long id) {
		return playerService.deletePlayer(id);
	}

	@PostMapping ("/sponsor")
	public Sponsor createSponsor(@RequestParam(value="name") String name, 
			@RequestParam(value="description",required = false) String description,
			@RequestParam(value="street",required = false) String street,
			@RequestParam(value="city", required = false) String city,
			@RequestParam(value="state", required = false) String state,
			@RequestParam(value = "zip", required = false) String zip) {

		Address address = new Address(street, city, state, zip);
		Sponsor sponsor = new Sponsor(name, description, address);
		return sponsorService.createSponsor(sponsor);
	}
	
	@PostMapping ("/sponsor/{id}")
	public Sponsor updateSponsor(@RequestParam(value="name") String name, 
			@RequestParam(value="description",required = false) String description,
			@RequestParam(value="street",required = false) String street,
			@RequestParam(value="city", required = false) String city,
			@RequestParam(value="state", required = false) String state,
			@RequestParam(value = "zip", required = false) String zip,
			@PathVariable("id") Long id) {

		Address address = new Address(street, city, state, zip);
		Sponsor sponsor = new Sponsor(name, description, address);
		sponsor.setId(id);
		return sponsorService.updateSponsor(sponsor);
	}

	@GetMapping("/sponsor/{id}")
	public Sponsor geteSponsor(@PathVariable("id") Long id) {
		Sponsor sponsor = sponsorService.getSponsor(id);
		if(sponsor == null)
			throw new EntityNotFoundException();
		return sponsor;
	}
	
	@DeleteMapping("/sponsor/{id}")
	public Sponsor deleteSponsor(@PathVariable("id") Long id) {
		return sponsorService.deleteSponsor(id);
	}

}
