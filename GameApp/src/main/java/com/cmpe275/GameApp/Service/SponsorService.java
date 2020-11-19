package com.cmpe275.GameApp.Service;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmpe275.GameApp.Entity.Sponsor;
import com.cmpe275.GameApp.Repository.SponsorRepository;

@Service
public class SponsorService {
	
    @Autowired
	SponsorRepository sponsorRepository;
	
	public Sponsor createSponsor(Sponsor sponsor) {
		return sponsorRepository.save(sponsor);
	}
	
	public Sponsor updateSponsor(Sponsor sponsor) {
		if(!sponsorRepository.existsById(sponsor.getId()))
			throw new EntityNotFoundException();
		return sponsorRepository.save(sponsor);	
	}

    public Sponsor getSponsor(Long id) {
        return sponsorRepository.findById(id).orElse(null);
	}
    
    public Sponsor deleteSponsor(Long id) {
    	Sponsor sponsor = sponsorRepository.findById(id).orElse(null);
    	sponsorRepository.deleteById(id);
    	return sponsor;
    }

	
}