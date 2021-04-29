package com.victor.cardverification.Pojos.Response;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Prop {
    private ArrayList<Integer> pricesRange;
    private ArrayList<Airline> airline;
    private ArrayList<Airline> departingAirline;
    private ArrayList<Integer> stops;
    private ArrayList<String> cabin;
    ArrayList<ArrayList<ItemsByAirline> > itemsByAirline;
}
