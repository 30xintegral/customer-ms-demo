package com.example.customermsdemo.service;

import com.example.customermsdemo.dto.request.CustomerRequest;
import com.example.customermsdemo.dto.response.CustomerResponse;
import com.example.customermsdemo.entity.Customer;
import com.example.customermsdemo.mapper.CustomerMapper;
import com.example.customermsdemo.repository.CustomerRepository;
import com.example.customermsdemo.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    @Override
    public void create(CustomerRequest customerRequest) {
        Customer customer = new Customer();
        customer.setName(customerRequest.getName());
        customer.setAge(customerRequest.getAge());
        customer.setSurname(customerRequest.getSurname());
        customer.setPinCode(customerRequest.getPinCode());
        customer.setAddress(customerRequest.getAddress());
        customer.setBalance(customerRequest.getBalance());
        customerRepository.save(customer);
    }

    @Override
    public CustomerResponse getById(Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(()-> new RuntimeException("No such customer found by id:"+id));
        return CustomerMapper.INSTANCE.mapEntityToDto(customer);
    }

    @Override
    public List<CustomerResponse> getAll() {
        List<Customer> customers = customerRepository.findAll();
        List<CustomerResponse> customerResponseList = new ArrayList<>();
        for (Customer customer:
             customers) {
            CustomerResponse customerResponse = CustomerMapper.INSTANCE.mapEntityToDto(customer);
            customerResponseList.add(customerResponse);
        }

        return customerResponseList;
    }

    @Override
    public void decreaseBalanceBy(Long id, double amount) {
        Customer customer = customerRepository.findById(id).orElseThrow(()-> new RuntimeException("No such customer found"));
        if (customer.getBalance()<amount){
            throw new RuntimeException("Insufficient balance");
        }
        customerRepository.decreaseBalanceBy(id, amount);
    }
}
