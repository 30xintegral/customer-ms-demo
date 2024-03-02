package com.example.customermsdemo.dto.request;

import lombok.Data;

@Data
public class CustomerRequest {
    private String pinCode;

    private String name;

    private String surname;

    private int age;

    private String address;

    private double balance;
}
