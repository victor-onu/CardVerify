package com.victor.cardverification.Pojos.Response;

import lombok.Data;

import java.util.ArrayList;

@Data
public class FlightSearchRequest {
    private String sessionId;
    private String supplier;
    private String tabHash;
    private int adultCount;
    private int childCount;
    private int infantCount;
    private boolean flexibleDate;
    private boolean directFlight;
    private ArrayList<?> airlines;
    private ArrayList<?> originDestinationRequests;
    private ArrayList<?> passengerType;
    private int seatsCount;
    private String cabin;
    private String salesCategory;
    private String ticketLocale;
    private String tripType;
    private SearchRequestHeader searchRequestHeader;
    private Long elapseTime;


    @Data
    private class SearchRequestHeader {
        private long searchFrom;
        private long searchTo;
    }
}
