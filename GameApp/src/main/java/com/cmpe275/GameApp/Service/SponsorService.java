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
	
    
	/** 
	 * Create Sponsor Method
	 * @param sponsor Sponsor Object
	 * @return Sponsor
	 */
	@Transactional
	public Sponsor createSponsor(Sponsor sponsor) {
		return sponsorRepository.save(sponsor);
	}
	
	
	/** 
	 * Method for Updating the Sponsor
	 * @param sponsor
	 * @return SponsorDTODeep
	 */
	@Transactional
	public SponsorDTODeep updateSponsor(Sponsor sponsor) {
		if(!sponsorRepository.existsById(sponsor.getId()))
			throw new EntityNotFoundException("Sponsor Id Does Not Exist!");
		return convertToSponsorDTO(sponsorRepository.save(sponsor));	
	}

	
	/** 
	 * Get the Sponsor value by Id
	 * @param id Id of the sponsor
	 * @return SponsorDTODeep Deep copy of the sponsor object
	 */
	@Transactional
    public SponsorDTODeep getSponsor(Long id) {
        Sponsor sponsor = sponsorRepository.findById(id).orElse(null);
        if(sponsor == null)
			throw new EntityNotFoundException("Sponsor Id Does Not Exist!");
       
        return convertToSponsorDTO(sponsor);
	}
    
	
	/** 
	 * Delete the sponsor object By Id
	 * @param id Id of the Sponsor
	 * @return SponsorDTODeep Deep copy of the Deleted Sponsor Object
	 */
	@Transactional
    public SponsorDTODeep deleteSponsor(Long id) {
    	Sponsor sponsor = sponsorRepository.findById(id).orElse(null);
    	sponsorRepository.deleteById(id);
    	return convertToSponsorDTO(sponsor);
    }

    
	/** 
	 * Convert the spnsor object to DTO object
	 * @param sponsor Sponsor object to be converted
	 * @return SponsorDTODeep Deep copy of the sponsor object
	 */
	private SponsorDTODeep convertToSponsorDTO(Sponsor sponsor) {
    	this.modelMapper.typeMap(Sponsor.class, SponsorDTODeep.class).addMapping(Sponsor::getPlayers, SponsorDTODeep::setPlayers);
    	SponsorDTODeep sponsorDTO = modelMapper.map(sponsor, SponsorDTODeep.class);
    	return sponsorDTO;
    }
}