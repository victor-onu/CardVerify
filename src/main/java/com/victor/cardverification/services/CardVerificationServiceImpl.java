package com.victor.cardverification.services;

import com.victor.cardverification.Pojos.CardDetails;
import com.victor.cardverification.dto.CardResponse;
import com.victor.cardverification.dto.HitPayload;
import com.victor.cardverification.dto.HitResponse;
import com.victor.cardverification.dto.Payload;
import com.victor.cardverification.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class CardVerificationServiceImpl implements CardVerificationService {

    @Autowired
    private RestTemplate restTemplate;

    private LinkedHashMap<String, Integer> hits = new LinkedHashMap<>();
    private int count = 0;

    @Override
    public CardResponse getCardDetails( String cardNumber) {
        CardDetails cardDetails = restTemplate.getForObject("https://lookup.binlist.net/" + cardNumber, CardDetails.class);
        if (cardDetails == null){
            throw new CustomException("Details not found", HttpStatus.NOT_FOUND);
        }
        CardResponse cardResponse = new CardResponse();
        cardResponse.setSuccess(true);
        Payload payload = new Payload();
        payload.setBank(cardDetails.getBank().getName());
        payload.setScheme(cardDetails.getScheme());
        payload.setType(cardDetails.getType());
        cardResponse.setPayload(payload);
        countHit(cardNumber);
        return cardResponse;
    }

    public void countHit(String cardNumber){
        if (hits.containsKey(cardNumber)){
            count = hits.get(cardNumber) + 1;
            hits.put(cardNumber, count);
        }else hits.put(cardNumber, 1);
    }

    @Override
    public HitResponse countHits(Integer start, Integer limit) {
        LinkedHashMap<String, Integer> payloadHit = new LinkedHashMap<>();
        try {
            if (hits.isEmpty()) {
                throw new CustomException("There is no hit recorded", HttpStatus.BAD_REQUEST);
            } else {
                List<String> list = new ArrayList<>();
                for (String key : hits.keySet()){
                    list.add(key);
                }
                int end;
                if (start <= 0) start = 1;
                else if(start > hits.size()) throw new CustomException("Start number way too high, please reduce start number", HttpStatus.BAD_REQUEST);
                if ((start + limit) > hits.size()) end = hits.size() + 1;
                else end = start + limit;

                for (int i = start; i < end ; i++) {
                    payloadHit.put(list.get(i - 1), hits.get(list.get(i - 1)));
                }
                System.out.println(payloadHit);
                HitResponse hitResponse = new HitResponse();
                hitResponse.setStart(start);
                hitResponse.setLimit(limit);
                hitResponse.setSize(hits.size());
                HitPayload hitPayload = new HitPayload();
                hitPayload.setPayload(payloadHit);
                hitResponse.setPayload(hitPayload);
                hitResponse.setSuccess(true);
                return hitResponse;
            }
        } catch (Exception exception){
            throw new CustomException(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
