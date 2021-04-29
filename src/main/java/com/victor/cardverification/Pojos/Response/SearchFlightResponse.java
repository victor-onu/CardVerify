package com.victor.cardverification.Pojos.Response;

import lombok.Data;

import java.util.ArrayList;

@Data
public class SearchFlightResponse {
    private boolean status;
    private String sessionId;
    private FlightSearchRequest flightSearchRequest;
    private Prop prop;
    private String desc;
    private Result result;

    @Data
    private static class Result {
        private FlightSearchRequest flightSearchRequest;
        private ArrayList<ItemsByAirline> pricedItineraryWSResponses;
        private ArrayList<?> connectionItineraryResponses;
    }
}
