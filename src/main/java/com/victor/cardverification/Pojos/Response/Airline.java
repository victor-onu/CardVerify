package com.victor.cardverification.Pojos.Response;

import lombok.Data;

@Data
public class Airline {
    private String code;
    private String name;
    private int startingPrice;
    private String ref;
    private int count;
}
