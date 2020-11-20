package com.cmpe275.GameApp.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmpe275.GameApp.Entity.Sponsor;
import com.cmpe275.GameApp.Repository.SponsorRepository;

@Service
public class SponsorService {
	
    @Autowired
	SponsorRepository sponsorRepository;
    
    @Autowired
    ModelMapper modelMapper;
	
    @Transactional
	public Sponsor createSponsor(Sponsor sponsor) {
		return sponsorRepository.save(sponsor);
	}
	
	@Transactional
	public SponsorDTODeep updateSponsor(Sponsor sponsor) {
		if(!sponsorRepository.existsById(sponsor.getId()))
			throw new EntityNotFoundException();
		return convertToSponsorDTO(sponsorRepository.save(sponsor));	
	}

	@Transactional
    public SponsorDTODeep getSponsor(Long id) {
        Sponsor sponsor = sponsorRepository.findById(id).orElse(null);
        if(sponsor == null)
			throw new EntityNotFoundException();
       
        return convertToSponsorDTO(sponsor);
	}
    
	@Transactional
    public SponsorDTODeep deleteSponsor(Long id) {
    	Sponsor sponsor = sponsorRepository.findById(id).orElse(null);
    	sponsorRepository.deleteById(id);
    	return convertToSponsorDTO(sponsor);
    }

    private SponsorDTODeep convertToSponsorDTO(Sponsor sponsor) {
    	this.modelMapper.typeMap(Sponsor.class, SponsorDTODeep.class).addMapping(Sponsor::getPlayers, SponsorDTODeep::setPlayers);
    	SponsorDTODeep sponsorDTO = modelMapper.map(sponsor, SponsorDTODeep.class);
    	return sponsorDTO;
    }
}