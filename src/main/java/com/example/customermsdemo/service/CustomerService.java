package com.example.customermsdemo.service;

import com.example.customermsdemo.dto.request.CustomerRequest;
import com.example.customermsdemo.dto.response.CustomerResponse;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CustomerService {
    void create(CustomerRequest customerRequest);

    CustomerResponse getById(Long id);

    List<CustomerResponse> getAll();

    void decreaseBalanceBy(Long id, double amount);
}
