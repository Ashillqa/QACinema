package com.qa.controller;

import com.qa.commons.Response;
import com.qa.service.StripeService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PaymentController {

    @Value("${stripe.keys.public}")
    private String API_PUBLIC_KEY;

    private StripeService stripeService;

    public PaymentController(StripeService stripeService) {
        this.stripeService = stripeService;
    }

    @PostMapping("/create-charge")
    public @ResponseBody
    Response createCharge(String email, String token, double amount) {
        //validate data
        if (token == null) {
            return new Response(false, "Stripe payment token is missing. Please, try again later.");
        }

        //create charge
        String chargeId = stripeService.createCharge(email, token, (int)(amount*100)); //$9.99 USD
        if (chargeId == null) {
            return new Response(false, "An error occurred while trying to create a charge.");
        }

        // You may want to store charge id along with order information

        return new Response(true, "Success! Your charge id is " + chargeId);
    }

}
