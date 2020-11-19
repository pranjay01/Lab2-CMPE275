package com.cmpe275.GameApp.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmpe275.GameApp.Entity.Player;
import com.cmpe275.GameApp.Repository.PlayerRepository;

@Service
public class PlayerService {

	@Autowired
	PlayerRepository playerRepository;

	public Player createPlayer(Player player) {
		return playerRepository.save(player);
	}

	public Player updatePlayer(Player player) {
		if(!playerRepository.existsById(player.getId()))
			throw new EntityNotFoundException();
		return playerRepository.save(player);
	}

	@Transactional
	public Player getPlayer(Long id) {
		return playerRepository.findById(id).orElse(null);
	}
	
	public Player deletePlayer(Long id) {
		Player player = playerRepository.findById(id).orElse(null);
		playerRepository.deleteById(id);
		return player;
	}
}

