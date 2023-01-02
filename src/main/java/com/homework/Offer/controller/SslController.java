package com.homework.Offer.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.ssl.commerz.api.SSLCommerz;

@Controller
public class SslController {
	
	 
	
	@RequestMapping("/checkout")
 public RedirectView success(@RequestParam("price") int price) throws Exception {
	 int pr = price;
	 String s = String.valueOf(price);
	 SSLCommerz sslcommerz = new SSLCommerz("arif61a848ad3ba96", "arif61a848ad3ba96@ssl", true);
	 Map<String, String> postData = new HashMap<String, String>();
     postData.put("total_amount", s);
     postData.put("tran_id", "TESTASPNET1234");
     postData.put("success_url",  "ssl-success-page");
     postData.put("fail_url", "https://sandbox.sslcommerz.com/developer/fail.php");
     postData.put("cancel_url", "https://sandbox.sslcommerz.com/developer/cancel.php");
     postData.put("version", "3.00");
     postData.put("cus_name", "ABC XY");
     postData.put("cus_email", "abc.xyz@mail.co");
     postData.put("cus_add1", "Address Line On");
     postData.put("cus_add2", "Address Line Tw");
     postData.put("cus_city", "City Nam");
     postData.put("cus_state", "State Nam");
     postData.put("cus_postcode", "Post Cod");
     postData.put("cus_country", "Countr");
     postData.put("cus_phone", "0111111111");
     postData.put("cus_fax", "0171111111");
     postData.put("ship_name", "ABC XY");
     postData.put("ship_add1", "Address Line On");
     postData.put("ship_add2", "Address Line Tw");
     postData.put("ship_city", "City Nam");
     postData.put("ship_state", "State Nam");
     postData.put("ship_postcode", "Post Cod");
     postData.put("ship_country", "Countr");
     postData.put("value_a", "ref00");
     postData.put("value_b", "ref00");
     postData.put("value_c", "ref00");
     postData.put("value_d", "ref00");	
     String url = sslcommerz.initiateTransaction(postData, false);
     RedirectView redirectView = new RedirectView();
     redirectView.setUrl(url);
     System.out.println(url);
     return redirectView;
 }
}
