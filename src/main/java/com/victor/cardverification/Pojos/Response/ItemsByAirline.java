package com.victor.cardverification.Pojos.Response;

import lombok.Data;

import java.util.ArrayList;

@Data
public class ItemsByAirline {
    private AirItineraryWSResponse airItineraryWSResponse;

    @Data
    private static class AirItineraryWSResponse {
        private ArrayList<OriginDestinationWSResponses> originDestinationWSResponses;

        @Data
        private static class OriginDestinationWSResponses{
            private ArrayList<FlightSegmentWSResponses> flightSegmentWSResponses;

            @Data
            private static class FlightSegmentWSResponses {
                private String departureAirport;
                private String arrivalAirport;
                private String departureAirportCode;
                private DepartureAirportTbl departureAirportTbl;

                @Data
                private static class DepartureAirportTbl {
                    private String airCode;
                    private String airportName;
                    private String countryName;
                    private String countryCode;
                    private String cityCode;
                    private String city;
                    private String state;
                    private String typeCode;
                }

                private String departureTerminal;
                private String arrivalAirportCode;
                private ArrivalAirportTbl arrivalAirportTbl;

                @Data
                private static class ArrivalAirportTbl {
                    private String airCode;
                    private String airportName;
                    private String countryName;
                    private String countryCode;
                    private String cityCode;
                    private String city;
                    private String state;
                    private String typeCode;

                }

                private Object arrivalTerminal;
                private String airportCodeContext;
                private String departureTimeZone;
                private String arrivalTimeZone;
                private String departureDateTime;
                private String arrivalDateTime;
                private String duration;
                private MarketingAirline marketingAirline;

                @Data
                private static class MarketingAirline {
                    private String name;
                    private String airlineCode;
                }

                private String marketingAirlineCode;
                private OperatingAirline operatingAirline;

                @Data
                private static class OperatingAirline {
                    private String name;
                    private String airlineCode;
                }

                private String operatingAirlineCode;
                private String cabin;
                private String RPH;
                private ArrayList<Baggages> baggages;

                @Data
                private static class Baggages {
                    private String quantity;
                    private String bagDesc;
                    private String passengerCat;
                }

                private String flightNumber;
                private String resBookDesigCode;
                private String airEquipType;
                private Integer numberInParty;
                private Object mealCode;
                private Integer stopQuantity;
                private String elapseTime;
                private String originDestinationType;
                private String marriageGrp;
            }

            private String originAirport;
            private String flightNote;
            private String flightNumber;
            private String equipmentName;
            private String destinationAirport;
            private String originAirportCode;
            private String destinationAirportCode;
            private String arrivalDateTime;
            private String departureDateTime;
            private String duration;
            private Boolean isNextDayArrival;
            private MarketingAirline marketingAirline;

            @Data
            private static class MarketingAirline{
                private String name;
                private String airlineCode;
            }

            private String marketingAirlineCode;
            private OperatingAirline operatingAirline;

            @Data
            private static class OperatingAirline {
                private String name;
                private String airlineCode;
            }
           private String operatingAirlineCode;
           private String cabin;
           private ArrayList<Baggages> baggages;

           @Data
            private static class Baggages{
               private String quantity;
               private String bagDesc;
               private String passengerCat;
           }

           private Boolean isMultiAirline;
           private Integer numberOfStops;
           private String terminal;
           private Integer isOvernightFlight;
           private Integer directionId;
           private Long refNumber;
           private String tripCode;
           private String seatAvailable;
           private OriginAirportTbl originAirportTbl;

           @Data
            private static class OriginAirportTbl{
               private String airCode;
               private String airportName;
               private String countryName;
               private String cityCode;
               private String city;
               private String state;
               private String typeCode;
           }

         private DestinationAirportTbl destinationAirportTbl;
           @Data
            private static class DestinationAirportTbl{
               private String airCode;
               private String airportName;
               private String countryName;
               private String cityCode;
               private String city;
               private String state;
               private String typeCode;
           }

           private ArrayList<String> layover;
        }

        private ArrayList<OriginDestinationCombinations> originDestinationCombinations;

        @Data
        private static class OriginDestinationCombinations{
            private String validatingAirlineCode;
            private Boolean forceEticketing;
            private String indexList;
            private String combinationId;
            private String eTicketEligible;
            private long serviceFeeAmount;
        }

        private String directionIndicator;

    }

    private PricingInfoWSResponse pricingInfoWSResponse;

    @Data
    private static class PricingInfoWSResponse{
        private Long oldTotalFare;
        private Long oldGdsBaseFare;
        private Long gdsBaseFare;
        private Long gdsTaxFare;
        private Long gdsTotalFare;
        private Long subCharges;
        private String gdsEquivCurrency;
        private BaseFare baseFare;

        @Data
        private static class BaseFare {
            private String currencyCode;
            private Long amount;
        }
        private ArrayList<TotalTax> totalTax;

        @Data
        private static class TotalTax {
            private String currency;
            private Long taxCode;
            private String description;
            private Long amount;
        }
        private ArrayList<?> internalTaxes;
        private Long totalFare;
        private String currencyCode;
        private Long decimalPlaces;
        private String pricingSource;
        private ArrayList<FareItems> fareItems;

        @Data
        private static class FareItems {
            private String itemCode;
            private String itemName;
            private String itemDesc;
            private Long amount;
        }
        private ArrayList<?> b2bAdditionalMarkup;
        private ArrayList<PassengerFare> passengerFare;

        @Data
        private static class PassengerFare {
            private String quantity;
            private PassengerType passengerType;

            @Data
            private static class PassengerType{
                private Long quantity;
                private String code;
            }

            private ArrayList<TicketingRules> ticketingRules;

            @Data
            private static class TicketingRules{
                private String code;
                private String description;
            }

            private PassengerFareInner passengerFare;

            @Data
            private static class PassengerFareInner{
                private Long baseFare;
                private Long totalTax;
                private Long totalFare;
            }
        }

        private String priceDirection;
        private String ref;
        private String cabin;
        private String resBookDesigCode;
        private String resBookDesigQuantity;
        private String cabinClassCode;
        private Long dispenseValueAmount;

    }

    private ArrayList<?> owcPricesInfoWSResponses;
    private ArrayList<?> owcPricesInfoWSResponsesOptions;
    private TicketingInfoWSResponse ticketingInfoWSResponse;

    @Data
    private static class TicketingInfoWSResponse{
        private String eTicketEligibility;
    }
    
    private String ref;
    private Boolean oneWayCombinable;
    private Airline airline;

    @Data
    private static class Airline{
        private String name;
        private String airlineCode;
    }

    private String airlineCode;
    private Long direction;
    private String cabin;
    private Long cache;
    private String supplier;
    private String ticketPolicy;
    private String salesCategory;
    private String ticketLocale;
    private String sessionId;
    private String sequenceNumber;
    private String selectedCombinationId;
}
