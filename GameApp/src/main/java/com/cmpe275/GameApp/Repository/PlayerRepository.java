package com.cmpe275.GameApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cmpe275.GameApp.Entity.Player;

public interface PlayerRepository extends JpaRepository<Player, Integer> {

}
