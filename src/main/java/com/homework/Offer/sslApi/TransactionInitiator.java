package com.homework.Offer.sslApi;

import java.util.Map;

import com.homework.Offer.sslUtill.ParameterBuilder;

public class TransactionInitiator {
	  public String initTrnxnRequest() {
	        String response = "";
	        try {
	            /**
	             * All parameters in payment order should be constructed in this follwing postData Map
	             * keep an eye on success fail url correctly.
	             * insert your success and fail URL correctly in this Map
	             */
	            Map<String, String> postData = ParameterBuilder.constructRequestParameters();
	            /**
	             * Provide your SSL Commerz store Id and Password by this following constructor.
	             * If Test Mode then insert true and false otherwise.
	             */
	            SSLCommerz sslcz = new SSLCommerz("testbox", "qwerty", true);

	            /**
	             * If user want to get Gate way list then pass isGetGatewayList parameter as true
	             * If user want to get URL as returned response, pass false.
	             */
	            response = sslcz.initiateTransaction(postData, false);
	            return response;
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return response;
	    }

}
