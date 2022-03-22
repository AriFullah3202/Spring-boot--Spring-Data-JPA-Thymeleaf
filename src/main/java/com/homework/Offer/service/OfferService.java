package com.homework.Offer.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.homework.Offer.entity.Offer;


public interface OfferService {
  List<Offer> getAllOffer();
  void saveOffer(Offer offer);
  Offer getOffer(long id);
  void deleteOfferById(long id);
  Page<Offer> findPaginated(int pageNo, int page);
}
