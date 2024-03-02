package com.example.customermsdemo.dto.response;

import lombok.Data;

@Data
public class CustomerResponse {
    private Long id;

    private String pinCode;

    private String name;

    private String surname;

    private int age;

    private String address;

    private double balance;
}
