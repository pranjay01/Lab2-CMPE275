package com.cmpe275.GameApp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cmpe275.GameApp.Entity.Player;
import com.cmpe275.GameApp.Service.PlayerService;

@RestController
public class GameAppController {
	
	@Autowired
	PlayerService playerService;
	
	@PostMapping ("/player")
	public Player createPlayer(@RequestParam(value="firstname") String firstname, 
			@RequestParam(value="lastname") String lastname,
			@RequestParam(value="email") String email,
			@RequestParam(value="description", required = false) String description,
			@RequestParam(value="sponsorId", required = false) Integer sponsorId) {
		
		Player player = new Player(firstname, lastname, email, description, sponsorId);
		System.out.println("controller");
		return playerService.createPlayer(player);
	}

}
