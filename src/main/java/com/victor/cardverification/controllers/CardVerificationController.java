package com.victor.cardverification.controllers;

import com.victor.cardverification.apiresponse.ApiResponse;
import com.victor.cardverification.dto.CardResponse;
import com.victor.cardverification.dto.HitResponse;
import com.victor.cardverification.services.CardVerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("card-scheme/")
public class CardVerificationController {

    private final CardVerificationService CardVerificationService;

    @Autowired
    public CardVerificationController(CardVerificationService CardVerificationService) {
        this.CardVerificationService = CardVerificationService;
    }

    @GetMapping("/verify/{cardNumber}")
    public ResponseEntity<ApiResponse<CardResponse>> verifyCard(@PathVariable String cardNumber){
        CardResponse cardResponse = CardVerificationService.getCardDetails(cardNumber);
        ApiResponse<CardResponse> response = new ApiResponse<>(HttpStatus.OK);
        response.setMessage("Card retrieved successfully");
        response.setData(cardResponse);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/stats")
    public HitResponse hitCount(@RequestParam(value = "start", defaultValue = "1") Integer start, @RequestParam(value = "limit", defaultValue = "1") Integer limit){
    HitResponse hitResponse = CardVerificationService.countHits(start, limit);
    return hitResponse;
    }


}
