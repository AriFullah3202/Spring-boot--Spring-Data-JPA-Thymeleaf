package com.homework.Offer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.homework.Offer.entity.Offer;
import com.homework.Offer.service.OfferService;

@Controller
public class OfferController {
    @Autowired
	private OfferService offerService;
    
    @GetMapping("/")
    public String homepage(Model model) {
    	List<Offer> offer = offerService.getAllOffer();
    	model.addAttribute("listOfOffer", offer);
    	return "home";
    }
    @GetMapping("/offers")
    public String viewHomePage(Model model) {
    	model.addAttribute("hi", "welcome to my first list");
    	List<Offer> offer = offerService.getAllOffer();
    	System.out.println(offer);
    	model.addAttribute("listOfOffer", offer);
    	return findPage(1, model);
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
        return "edit-offer";
    }
    @PostMapping("/processUpdate/{id}")
    public String processUpdate(@PathVariable long id,
    		@ModelAttribute("offer") Offer offer, Model model) {
    	Offer exitingOffer = offerService.getOffer(id);
    	exitingOffer.setId(id);
    	exitingOffer.setCompanayName(offer.getCompanayName());
    	exitingOffer.setOfferDetails(offer.getOfferDetails());
    	exitingOffer.setPrice(offer.getPrice());
    	offerService.update(exitingOffer);
    	return"redirect:/offers";
    }
     
    @GetMapping("/delete")
    public String deleteOffer(@RequestParam("offerId") long id ){
        offerService.deleteOfferById(id);
    	return "redirect:/offers";
    }
    @GetMapping("/search")
    public String search(@RequestParam("keyword") String offerDetails , Model model) {
 	  List<Offer> offer = offerService.fatchOfferDetailsContaining(offerDetails);
 	  System.out.println("from search method "+offer.toString());
 	  model.addAttribute("searchObject", offer);
 	 return "search";
    }
    @GetMapping("/page/{pageNo}")
    public String findPage(@PathVariable(value = "pageNo") 
    int pageNo , Model model) {
    	int page = 2;
    	Page<Offer> findPaginated = offerService.findPaginated(pageNo, page);
    	List<Offer> listOffer = findPaginated.getContent();
    	model.addAttribute("currentPage", pageNo);
    	model.addAttribute("totalPage",findPaginated.getTotalPages() );
    	model.addAttribute("totalItems", findPaginated.getTotalElements());
    	model.addAttribute("listOfOffer", listOffer);
    	return "all-offer";
    }
}