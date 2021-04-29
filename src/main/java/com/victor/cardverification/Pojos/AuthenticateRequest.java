package com.victor.cardverification.Pojos;

import lombok.Data;



@Data
public class AuthenticateRequest {

    private String username;

    private String password;

    private String apiKey;
}
