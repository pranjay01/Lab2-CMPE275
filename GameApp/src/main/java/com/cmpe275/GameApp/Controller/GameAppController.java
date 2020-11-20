package com.cmpe275.GameApp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cmpe275.GameApp.Entity.Address;
import com.cmpe275.GameApp.Entity.Player;
import com.cmpe275.GameApp.Entity.Sponsor;
import com.cmpe275.GameApp.Service.PlayerDTODeep;
import com.cmpe275.GameApp.Service.PlayerService;
import com.cmpe275.GameApp.Service.SponsorDTODeep;
import com.cmpe275.GameApp.Service.SponsorService;

@RestController
public class GameAppController {

	@Autowired
	PlayerService playerService;

	@Autowired
	SponsorService sponsorService;

	@PostMapping ("/player")
	public PlayerDTODeep createPlayer(@RequestParam(value="firstname") String firstname, 
			@RequestParam(value="lastname") String lastname,
			@RequestParam(value="email") String email,
			@RequestParam(value="description", required = false) String description,
			@RequestParam(value = "sponsorId", required = false) Long sponsorId) {
		
		PlayerDTODeep player = playerService.createPlayer(firstname, lastname, email, description, sponsorId);
		return player;
	}

	@PutMapping ("/player/{id}")
	public PlayerDTODeep updatePlayer(@RequestParam(value="firstname") String firstname, 
			@RequestParam(value="lastname") String lastname,
			@RequestParam(value="email") String email,
			@RequestParam(value="description", required = false) String description,
			@RequestParam(value = "sponsorId", required = false) Long sponsorId, @PathVariable("id") Long id) {
		PlayerDTODeep player = playerService.updatePlayer(id,firstname, lastname, email, description, sponsorId);
		return player; 
	}

	@GetMapping ("/player/{id}")
	public PlayerDTODeep getPlayer(@PathVariable("id") Long id) {
		PlayerDTODeep player = playerService.getPlayer(id);
		return player; 
	}
	
	@DeleteMapping("/player/{id}")
	public PlayerDTODeep deletePlayer(@PathVariable("id") Long id) {
		PlayerDTODeep player = playerService.deletePlayer(id);
		return player; 
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
	
	@PutMapping ("/sponsor/{id}")
	public SponsorDTODeep updateSponsor(@RequestParam(value="name") String name, 
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
	public SponsorDTODeep geteSponsor(@PathVariable("id") Long id) {
		SponsorDTODeep sponsor = sponsorService.getSponsor(id);
		return sponsor;
	}
	
	@DeleteMapping("/sponsor/{id}")
	public SponsorDTODeep deleteSponsor(@PathVariable("id") Long id) {
		return sponsorService.deleteSponsor(id);
	}

	@PutMapping ("/opponents/{id1}/{id2}")
	public ResponseEntity<String> makeOpponents(@PathVariable("id1") Long id1,
			@PathVariable("id2") Long id2) {
		playerService.makeOpponents(id1, id2);
		return new ResponseEntity<String>("Opponent created", HttpStatus.OK);
	}

	@DeleteMapping("/opponents/{id1}/{id2}")
	public ResponseEntity<String> removeOpponent(@PathVariable("id1") Long id1,
			@PathVariable("id2") Long id2) {
		playerService.removeOpponents(id1, id2);
		return new ResponseEntity<String>("Opponent removed", HttpStatus.OK);
	}


}