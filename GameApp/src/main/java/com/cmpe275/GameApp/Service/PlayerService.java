package com.cmpe275.GameApp.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
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

	@Autowired
	ModelMapper modelMapper;

	@Transactional
	public PlayerDTODeep createPlayer(String firstname, String lastname, String email, String description, Long sponsorId) {
		Sponsor sponsor = null;
		if (sponsorId != null) {
			sponsor = sponsorRepository.findById(sponsorId).orElse(null);
		}
		Player player = new Player(firstname, lastname, email, description, sponsor);
		return convertToPlayerDTO(playerRepository.save(player));
	}

	@Transactional
	public PlayerDTODeep updatePlayer(Long id, String firstname, String lastname, String email, String description,
			Long sponsorId) {
		Sponsor sponsor = null;
		if (sponsorId != null) {
			sponsor = sponsorRepository.findById(sponsorId).orElse(null);
			if(sponsor == null)
				throw new DataIntegrityViolationException("Sponsor ID does not exist");
		}

		// Player player = new Player(firstname, lastname, email, description, sponsor);
		Player player = playerRepository.findById(id).orElse(null);
		// player.setId(id);
		if (player==null)
			throw new EntityNotFoundException();
		player.setFirstname(firstname);
		player.setLastname(lastname);
		player.setEmail(email);
		player.setDescription(description);
		player.setSponsor(sponsor);
		return convertToPlayerDTO(playerRepository.save(player));
	}

	@Transactional
	public PlayerDTODeep getPlayer(Long id) {
		Player player = playerRepository.findById(id).orElse(null);
		if(player == null)
			throw new EntityNotFoundException();
		player.getOpponents();
		return convertToPlayerDTO(player);
	}

	@Transactional
	public PlayerDTODeep deletePlayer(Long id) {
		Player player = playerRepository.findById(id).orElse(null);
		playerRepository.deleteById(id);
		return convertToPlayerDTO(player);
	}

	@Transactional
	public void makeOpponents(Long id1, Long id2) {
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
	}

	public void removeOpponents(Long id1, Long id2) {
		Player player1 = playerRepository.findById(id1).orElse(null);
		Player player2 = playerRepository.findById(id2).orElse(null);
		if (player1 == null || player2 == null) {
			throw new EntityNotFoundException();
		}
		if (player1.getOpponents().contains(player2) && player2.getOpponents().contains(player1)) {
			player1.getOpponents().remove(player2);
			player2.getOpponents().remove(player1);
			playerRepository.save(player1);
			playerRepository.save(player2);
		} else {
			throw new DataIntegrityViolationException("Not Opponents");
		}
	}

	private PlayerDTODeep convertToPlayerDTO(Player player) {
		this.modelMapper.typeMap(Player.class, PlayerDTODeep.class).addMapping(Player::getSponsor, PlayerDTODeep::setSponsor);
		this.modelMapper.typeMap(Player.class, PlayerDTODeep.class).addMapping(Player::getOpponents, PlayerDTODeep::setOpponents);
		PlayerDTODeep playerDTO = modelMapper.map(player, PlayerDTODeep.class);
		return playerDTO;
	}

	

}
