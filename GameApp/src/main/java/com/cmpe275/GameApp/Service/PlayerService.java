package com.cmpe275.GameApp.Service;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.cmpe275.GameApp.Entity.Player;
import com.cmpe275.GameApp.Entity.Sponsor;
import com.cmpe275.GameApp.Repository.PlayerRepository;
import com.cmpe275.GameApp.Repository.SponsorRepository;

@Service
public class PlayerService {

	@Autowired
	PlayerRepository playerRepository;

	@Autowired
	SponsorRepository sponsorRepository;

	public Player createPlayer(String firstname, String lastname, String email, String description, Long sponsorId) {
		Sponsor sponsor = null;
		if (sponsorId != null) {
			sponsor = sponsorRepository.findById(sponsorId).orElse(null);
		}
		Player player = new Player(firstname, lastname, email, description, sponsor);
		return playerRepository.save(player);
	}
	// public Player createPlayer(Player player) {
	// 	return playerRepository.save(player);
	// }

	public Player updatePlayer(Long id, String firstname, String lastname, String email, String description,
			Long sponsorId) {
		Sponsor sponsor = null;
		if (sponsorId != null) {
			sponsor = sponsorRepository.findById(sponsorId).orElse(null);
		}

		Player player = new Player(firstname, lastname, email, description, sponsor);
		player.setId(id);
		if (!playerRepository.existsById(player.getId()))
			throw new EntityNotFoundException();
		return playerRepository.save(player);
	}

	// public Player updatePlayer(Player player) {
	// 	if (!playerRepository.existsById(player.getId()))
	// 		throw new EntityNotFoundException();
	// 	return playerRepository.save(player);
	// }

	public Player getPlayer(Long id) {
		Player player = playerRepository.findById(id).orElse(null);
		player.getOpponents();
		return player;
	}

	public Player deletePlayer(Long id) {
		Player player = playerRepository.findById(id).orElse(null);
		playerRepository.deleteById(id);
		return player;
	}

	public Player makeOpponents(Long id1, Long id2) {
		Player player1 = playerRepository.findById(id1).orElse(null);
		Player player2 = playerRepository.findById(id2).orElse(null);
		if (player1 == null || player2 == null) {
			throw new EntityNotFoundException();
		}
		if (player1.getOpponents().contains(player2)) {
			throw new DataIntegrityViolationException("Already Opponents");
		}
		player1.getOpponents().add(player2);
		player2.getOpponents().add(player1);
		playerRepository.save(player1);
		playerRepository.save(player2);
		return null;
	}

}
