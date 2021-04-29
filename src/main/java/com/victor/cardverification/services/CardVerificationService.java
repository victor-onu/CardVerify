package com.victor.cardverification.services;

import com.victor.cardverification.dto.CardResponse;
import com.victor.cardverification.dto.HitResponse;

public interface CardVerificationService {

    CardResponse getCardDetails(String cardNumber);

    HitResponse countHits(Integer start, Integer limit);
}
