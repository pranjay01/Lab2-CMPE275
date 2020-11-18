package com.cmpe275.GameApp.Service;

import javax.transaction.Transactional;

import com.cmpe275.GameApp.Entity.Sponsor;
import com.cmpe275.GameApp.Repository.SponsorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SponsorService {
    	@Autowired
	SponsorRepository sponsorRepository;
	
	@Transactional
	public Sponsor createSponsor(Sponsor sponsor) {
		return sponsorRepository.save(sponsor);
	}

    public Sponsor getSponsor(Long id) {
        Sponsor sponsor = sponsorRepository.getOne(id);
        // System.out.println(sponsor);
		return sponsor;
	}
}