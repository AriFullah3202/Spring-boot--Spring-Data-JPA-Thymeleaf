package com.homework.Offer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.homework.Offer.entity.Offer;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long>{
	

}