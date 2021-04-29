package com.victor.cardverification.Pojos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class AuthenticateResult {
    public Error error;
    public Success success;
    public Content content;

    @lombok.Data
    public static class Error{
        public int status;
        public String message;
    }

    @lombok.Data
    public static class Success{
        public int status;
        public String message;
    }

    @lombok.Data
    public static class Data{
        public String fullname;
        public double banktopup;
        public String phone;
        public String email;
        public String merchantID;
        public String username;
        public String publicKey;
        public String gender;
        public String device;
        public String cashierID;
        public String issuerID;
        public double totalWithdrawal;
        public double commission;
        public int pointLeft;
        public int passwordchanged;
        public int totalPoint;
        public String issuerName;
        public String pin;
        public int cashin;
        public double totalDue;
        public double balance;
    }

    @lombok.Data
    public static class IssuerData{
        public String name;
        public String issuerID;
        public int isstaging;
        public String itype;
        public int issuertype;
    }

    @lombok.Data
    public static class AllowedIssuer{
        public String issuerID;
    }

    @lombok.Data
    public static class Content{
        public List<Data> data;
        public String token;
        public List<IssuerData> issuerData;
        public List<Object> payments;
        public List<AllowedIssuer> allowedIssuers;
    }
}
