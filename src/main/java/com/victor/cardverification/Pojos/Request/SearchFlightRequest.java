package com.victor.cardverification.Pojos.Request;

import lombok.Data;

import java.util.ArrayList;

@Data
public class SearchFlightRequest {
    private ArrayList<Segment> segments;

    @Data
    private static class Segment {
        private Origin origin;

        @Data
        private static class Origin{
            private String airCode;
            private String airportName;
            private String countryName;
            private String countryCode;
            private String cityCode;
            private String city;
            private String state;
            private String typeCode;

        }

        private Origin arriving;
        private String departureDate;

    }

    private String ticketPolicy;
    private String ticketLocale;
    private String salesCategory;
    private Boolean directFlight;
    private String preferredCabin;
    private String tabSessionId;
    private ArrayList<Passenger> passengers;

    @Data
    private static class Passenger{
        private Integer quantity;
        private String code;
    }
}
