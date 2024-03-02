package com.example.customermsdemo.mapper;

import com.example.customermsdemo.dto.response.CustomerResponse;
import com.example.customermsdemo.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class CustomerMapper {
    public static final CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    public abstract CustomerResponse mapEntityToDto(Customer customer);

    public abstract Customer mapDtoToEntity(CustomerResponse customerResponse);
}
