package com.example.customermsdemo.controller;

import com.example.customermsdemo.dto.request.CustomerRequest;
import com.example.customermsdemo.dto.response.CustomerResponse;
import com.example.customermsdemo.service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@AllArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping("/create")
    public void create(@RequestBody CustomerRequest customerRequest){
        customerService.create(customerRequest);
    }

    @GetMapping(value = {"/getCustomer", "getCustomer/{id}"})
    public ResponseEntity<?> getCustomer(@PathVariable(required = false) Long id){
        if (id==null){
            return ResponseEntity.ok().body(customerService.getAll());
        }
        else {
            return ResponseEntity.ok().body(customerService.getById(id));
        }
    }

    @PatchMapping("/decreaseBalance/{id}/{amount}")
    public void decreaseBalanceBy(@PathVariable Long id, @PathVariable double amount){
        customerService.decreaseBalanceBy(id, amount);
    }

    @PatchMapping("/increaseBalance/{id}/{amount}")
    public void increaseBalanceBy(@PathVariable Long id, @PathVariable double amount){
        customerService.increaseBalanceBy(id, amount);
    }
}
