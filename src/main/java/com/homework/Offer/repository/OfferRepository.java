package com.homework.Offer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.homework.Offer.entity.Offer;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long>{
	public Offer findByOfferDetails(String offerDetails);
	public Offer findByOfferDetailsIgnoreCase(String offerDetails);
	public List<Offer> findByOfferDetailsContaining(String offerDetaiils);

}