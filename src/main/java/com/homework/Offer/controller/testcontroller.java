package com.homework.Offer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class testcontroller {
    @GetMapping("/hello")
	public String test(Model model) {
    	model.addAttribute("hi", "hi Arif, you are using spring boot and thymeleaf");
	   return "hello-world";
   }
}
