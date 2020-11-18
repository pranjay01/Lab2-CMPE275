package com.cmpe275.GameApp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
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
	public Player createPlayer(@RequestParam(value="firstname") String firstname, 
			@RequestParam(value="lastname") String lastname,
			@RequestParam(value="email") String email,
			@RequestParam(value="description", required = false) String description,
			@RequestParam(value = "sponsorId", required = false) Long sponsorId) {

		Player player = new Player(firstname, lastname, email, description, sponsorId);
		System.out.println("controller");
		return playerService.createPlayer(player);
	}

	@PostMapping ("/player/{id}")
	public Player updatePlayer(@RequestParam(value="firstname") String firstname, 
			@RequestParam(value="lastname") String lastname,
			@RequestParam(value="email") String email,
			@RequestParam(value="description", required = false) String description,
			@RequestParam(value = "sponsorId", required = false) Long sponsorId, @PathVariable("id") Long id) {
		// System.out.println(id);
		Player player = new Player(firstname, lastname, email, description, sponsorId);
		player.setId(id);
		// System.out.println("controller");
		return playerService.updatePlayer(player);
	}
	
	@GetMapping ("/player/{id}")
	public Player getPlayer(@PathVariable("id") Long id) {
			// System.out.println(id);
		return playerService.getPlayer(id);
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
		System.out.println("controller");
		return sponsorService.createSponsor(sponsor);
	}
	
	@GetMapping("/sponsor/{id}")
	public Sponsor geteSponsor(@PathVariable("id") Long id) {
		
		return sponsorService.getSponsor(id);
	}

}
