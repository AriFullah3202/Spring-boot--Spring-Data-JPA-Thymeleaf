package com.homework.Offer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.homework.Offer.entity.Offer;
import com.homework.Offer.repository.OfferRepository;
@Service
public class OfferServiceImpl implements OfferService {
    
	
	@Autowired
	private OfferRepository offerRepository;
	
	@Override
	public List<Offer> getAllOffer() {
		
		return offerRepository.findAll();
	}

	@Override
	public void saveOffer(Offer offer) {
		this.offerRepository.save(offer);
	}

	@Override
	public Offer getOffer(long id) {
	    Optional<Offer> optional = offerRepository.findById(id);
		Offer offer = null;
		if(optional.isPresent()) {
			offer = optional.get();
		}else{
			throw new RuntimeException("id is not found :: "+id);
		}
		
	    return offer;
	}

	@Override
	public void deleteOfferById(long id) {
		offerRepository.deleteById(id);
	}

	@Override
	public Page<Offer> findPaginated(int pageNo, int page) {
		Pageable pageable = PageRequest.of(pageNo, page);
		return offerRepository.findAll(pageable);
	}

}
