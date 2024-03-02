package com.example.customermsdemo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "customers")
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String pinCode;

    private String name;

    private String surname;

    private int age;

    private String address;

    private double balance;
}
