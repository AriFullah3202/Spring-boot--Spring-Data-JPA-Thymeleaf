package com.homework.Offer.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.homework.Offer.entity.Offer;


@SpringBootTest
class OfferServiceTest {
    @Autowired
	private OfferService offerService;
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	@Disabled
	void testGetAllOffer() {
		List<Offer> offer = offerService.getAllOffer();
		System.out.println("offer" +offer);
	}
//	@Test
//	@DisplayName("get offer details using junit")
//	public void whenValidOfferDetails() {
//		String offerDetail = "Spring core";
//		Offer found = offerService.fatchOfferDetails(offerDetail);
//		assertEquals(offerDetail, found.getOfferDetails());
//		}
	

}
