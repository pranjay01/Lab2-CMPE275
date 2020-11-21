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

	
	/** 
	 * Method for Creating the New player
	 * @param firstname first Name of the player
	 * @param lastname last name of the player
	 * @param email email address of the player
	 * @param description Description for the player
	 * @param sponsorId Id of the Sponsor for the player
	 * @return PlayerDTODeep Deep object of the created player
	 */
	@Transactional
	public PlayerDTODeep createPlayer(String firstname, String lastname, String email, String description, Long sponsorId) {
		Sponsor sponsor = null;
		if (sponsorId != null) {
			sponsor = sponsorRepository.findById(sponsorId).orElse(null);
			if (sponsor == null){
				throw new DataIntegrityViolationException("Sponsor ID Does Not Exist!");
			}
		}
		Player player = new Player(firstname, lastname, email, description, sponsor);
		return convertToPlayerDTO(playerRepository.save(player));
	}

	
	/** 
	 * Update method for the player
	 * @param id Id of the Player to be updated
	 * @param firstname first Name of the player
	 * @param lastname last name of the player
	 * @param email email address of the player
	 * @param description Description for the player
	 * @param sponsorId Id of the Sponsor for the player
	 * @return PlayerDTODeep Deep copy of the player object
	 */
	@Transactional
	public PlayerDTODeep updatePlayer(Long id, String firstname, String lastname, String email, String description,
			Long sponsorId) {
		Sponsor sponsor = null;
		if (sponsorId != null) {
			sponsor = sponsorRepository.findById(sponsorId).orElse(null);
			if(sponsor == null)
				throw new DataIntegrityViolationException("Sponsor ID Does Not Exist!");
		}

		// Player player = new Player(firstname, lastname, email, description, sponsor);
		Player player = playerRepository.findById(id).orElse(null);
		// player.setId(id);
		if (player==null)
			throw new EntityNotFoundException("Player Not Exists!");
		player.setFirstname(firstname);
		player.setLastname(lastname);
		player.setEmail(email);
		player.setDescription(description);
		player.setSponsor(sponsor);
		return convertToPlayerDTO(playerRepository.save(player));
	}

	
	/** 
	 * Getter for the Player
	 * @param id Id of the Player
	 * @return PlayerDTODeep Deep copy of the Player Object
	 */
	@Transactional
	public PlayerDTODeep getPlayer(Long id) {
		Player player = playerRepository.findById(id).orElse(null);
		if(player == null)
			throw new EntityNotFoundException("Player Not Exists!");
		player.getOpponents();
		return convertToPlayerDTO(player);
	}

	
	/** 
	 * Delete method for the player
	 * @param id Id of the Player to be deleted
	 * @return PlayerDTODeep Deep copy of the Player Object
	 */
	@Transactional
	public PlayerDTODeep deletePlayer(Long id) {
		Player player = playerRepository.findById(id).orElse(null);
		playerRepository.deleteById(id);
		return convertToPlayerDTO(player);
	}

	
	/** 
	 * Method to make 2 players opponents
	 * @param id1 Id of player 1
	 * @param id2 Id of player 2
	 */
	@Transactional
	public void makeOpponents(Long id1, Long id2) {
		Player player1 = playerRepository.findById(id1).orElse(null);
		Player player2 = playerRepository.findById(id2).orElse(null);
		if (player1 == null || player2 == null) {
			throw new EntityNotFoundException("Player Not Exists!");
		}
		if (player1.getOpponents().contains(player2)) {
			throw new DataIntegrityViolationException("Players Are Already Opponents!");
		}
		player1.getOpponents().add(player2);
		player2.getOpponents().add(player1);
		playerRepository.save(player1);
		playerRepository.save(player2);
	}

	
	/** 
	 * Method for deleting opponent mapping of 2 players
	 * @param id1 Id of Player one
	 * @param id2 Id of player two
	 */
	public void removeOpponents(Long id1, Long id2) {
		Player player1 = playerRepository.findById(id1).orElse(null);
		Player player2 = playerRepository.findById(id2).orElse(null);
		if (player1 == null || player2 == null) {
			throw new EntityNotFoundException("Player Not Exists!");
		}
		if (player1.getOpponents().contains(player2) && player2.getOpponents().contains(player1)) {
			player1.getOpponents().remove(player2);
			player2.getOpponents().remove(player1);
			playerRepository.save(player1);
			playerRepository.save(player2);
		} else {
			throw new DataIntegrityViolationException("Players Are Not Opponents!");
		}
	}

	
	/** 
	 * Method for converting the Player object to DTO object
	 * @param player Input Player object
	 * @return PlayerDTODeep Deep copy of the Player object
	 */
	private PlayerDTODeep convertToPlayerDTO(Player player) {
		this.modelMapper.typeMap(Player.class, PlayerDTODeep.class).addMapping(Player::getSponsor, PlayerDTODeep::setSponsor);
		this.modelMapper.typeMap(Player.class, PlayerDTODeep.class).addMapping(Player::getOpponents, PlayerDTODeep::setOpponents);
		PlayerDTODeep playerDTO = modelMapper.map(player, PlayerDTODeep.class);
		return playerDTO;
	}

	

}
