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

	
	/** 
	 * Ping API to TEST application
	 * @return String
	 */
	@GetMapping ("/ping")
	public String getPlayer() {
		return "GameApp CMPE-275 running";
	}

	
	/** 
	 * @param firstname First Name of the Player
	 * @param lastname Last Name of the Player
	 * @param email Email Address of the Player
	 * @param description Description about the Player
	 * @param sponsorId Sponsor Id of the Player
	 * @return PlayerDTODeep Player Object Deep Copy
	 */
	@PostMapping ("/player")
	public PlayerDTODeep createPlayer(@RequestParam(value="firstname") String firstname, 
			@RequestParam(value="lastname") String lastname,
			@RequestParam(value="email") String email,
			@RequestParam(value="description", required = false) String description,
			@RequestParam(value = "sponsorId", required = false) Long sponsorId) {
		
		PlayerDTODeep player = playerService.createPlayer(firstname, lastname, email, description, sponsorId);
		return player;
	}

	
	/** 
	 * @param firstname First Name of the Player
	 * @param lastname Last Name of the Player
	 * @param email Email Address of the Player
	 * @param description Description about the Player
	 * @param sponsorId Sponsor Id of the Player
	 * @param id Path Paramater (Id of the Player to be updated)
	 * @return PlayerDTODeep Player Object Deep Copy
	 */
	@PutMapping ("/player/{id}")
	public PlayerDTODeep updatePlayer(@RequestParam(value="firstname") String firstname, 
			@RequestParam(value="lastname") String lastname,
			@RequestParam(value="email") String email,
			@RequestParam(value="description", required = false) String description,
			@RequestParam(value = "sponsorId", required = false) Long sponsorId, @PathVariable("id") Long id) {
		PlayerDTODeep player = playerService.updatePlayer(id,firstname, lastname, email, description, sponsorId);
		return player; 
	}

	
	/** 
	 * @param id Path Variable (Id of the Player to Get)
	 * @return PlayerDTODeep Player Object Deep Copy
	 */
	@GetMapping ("/player/{id}")
	public PlayerDTODeep getPlayer(@PathVariable("id") Long id) {
		PlayerDTODeep player = playerService.getPlayer(id);
		return player; 
	}
	
	
	/** 
	 * @param id Path Variable ( Id of the Player to be Deleted)
	 * @return PlayerDTODeep Player Object Deep Copy 
	 */
	@DeleteMapping("/player/{id}")
	public PlayerDTODeep deletePlayer(@PathVariable("id") Long id) {
		PlayerDTODeep player = playerService.deletePlayer(id);
		return player; 
	}

	
	/** 
	 * @param name Name of the Sponsor
	 * @param description Description for the Sponsor
	 * @param street Address Street of the Sponsor
	 * @param city City of the Sponsor
	 * @param state State of the sponsor
	 * @param zip Zip code of the sponsor
	 * @return Sponsor object (Details of the new Sponsor Created)
	 */
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
	
	
	/** 
	* @param name Name of the Sponsor
	 * @param description Description for the Sponsor
	 * @param street Address Street of the Sponsor
	 * @param city City of the Sponsor
	 * @param state State of the sponsor
	 * @param zip Zip code of the sponsor
	 * @return SponsorDTODeep Deep copy of the updated sponsor object
	 */
	@PutMapping ("/sponsor/{id}")
	public SponsorDTODeep updateSponsor(@RequestParam(value="name") String name, 
			@RequestParam(value="description",required = false) String description,
			@RequestParam(value="street",required = false) String street,
			@RequestParam(value="city", required = false) String city,
			@RequestParam(value="state", required = false) String state,
			@RequestParam(value = "zip", required = false) String zip,
			@PathVariable("id") Long id) {

		// Address address = new Address(street, city, state, zip);
		// Sponsor sponsor = new Sponsor(name, description, address);
		// sponsor.setId(id);
	return	sponsorService.updateSponsor(name, description,street, city, state, zip,id);
		// return sponsorService.getSponsor(id);
	}

	
	/** 
	 * @param id Sponsor Id to find in DB
	 * @return SponsorDTODeep Deep copy of the sponsor object
	 */
	@GetMapping("/sponsor/{id}")
	public SponsorDTODeep geteSponsor(@PathVariable("id") Long id) {
		SponsorDTODeep sponsor = sponsorService.getSponsor(id);
		return sponsor;
	}
	
	
	/** 
	 * @param id Id of the sponsor to Delete
	 * @return SponsorDTODeep deep copy of the sponsor object
	 */
	@DeleteMapping("/sponsor/{id}")
	public SponsorDTODeep deleteSponsor(@PathVariable("id") Long id) {
		return sponsorService.deleteSponsor(id);
	}

	
	/** 
	 * @param id1 Id of the Player one
	 * @param id2 Id of the Player two
	 * @return ResponseEntity<String> Response of the API
	 */
	@PutMapping ("/opponents/{id1}/{id2}")
	public ResponseEntity<String> makeOpponents(@PathVariable("id1") Long id1,
			@PathVariable("id2") Long id2) {
		playerService.makeOpponents(id1, id2);
		return new ResponseEntity<String>("Opponent created", HttpStatus.OK);
	}

	
	/** 
	 * @param id1 Id of the Player One
	 * @param id2 Id of the Player Two
	 * @return ResponseEntity<String> Response of the API
	 */
	@DeleteMapping("/opponents/{id1}/{id2}")
	public ResponseEntity<String> removeOpponent(@PathVariable("id1") Long id1,
			@PathVariable("id2") Long id2) {
		playerService.removeOpponents(id1, id2);
		return new ResponseEntity<String>("Opponent removed", HttpStatus.OK);
	}


}