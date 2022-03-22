package com.homework.Offer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.homework.Offer.entity.Offer;
import com.homework.Offer.service.OfferService;

@Controller
public class OfferController {
    @Autowired
	private OfferService offerService;
    
    @GetMapping("/offers")
    public String viewHomePage(Model model) {
    	model.addAttribute("hi", "welcome to my first list");
    	List<Offer> offer = offerService.getAllOffer();
    	System.out.println(offer);
    	model.addAttribute("listOfOffer", offer);
    	return "all-offer";
    }
    @GetMapping("/saveOffer")
    public String saveOffer(@ModelAttribute("offer") Offer offer) {
    	System.out.println("hello i am from save");
    	return"addOffer";
    }
    @PostMapping("/processOffer")
    public String processOffer(@ModelAttribute("offer") Offer offer) {
    	offerService.saveOffer(offer);
    	return"redirect:/offers";
    }
    @GetMapping("/update")
    public String updateOffer(@RequestParam("offerId") long id , Model model) {
        Offer offer = offerService.getOffer(id);
    	model.addAttribute("offer", offer);
        return "addOffer";
    }
    @DeleteMapping("/delete")
    public String deleteOffer(@RequestParam("offerId") long id ){
        offerService.deleteOfferById(id);
    	return "redirect:/";
    }
}
