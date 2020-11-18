package com.cmpe275.GameApp.Service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmpe275.GameApp.Entity.Player;
import com.cmpe275.GameApp.Repository.PlayerRepository;

@Service
public class PlayerService {

	@Autowired
	PlayerRepository playerRepository;
	
	@Transactional
	public Player createPlayer(Player PLAYER) {
		return playerRepository.save(PLAYER);
	}

	public Player updatePlayer(Player player) {
		return playerRepository.save(player);
	}

	public Player getPlayer(Long id) {
		 Player player = playerRepository.getOne(id);
        // System.out.println(sponsor);
		return player;
	}
}
