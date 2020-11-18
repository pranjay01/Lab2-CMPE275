package com.cmpe275.GameApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cmpe275.GameApp.Entity.Sponsor;

public interface SponsorRepository extends JpaRepository<Sponsor, Integer> {

}
