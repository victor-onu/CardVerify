package com.victor.cardverification.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedHashMap;

@Data
public class HitResponse {
    private boolean success;
    private Integer start;
    private Integer limit;
    private Integer size;
    private HitPayload payload;
}