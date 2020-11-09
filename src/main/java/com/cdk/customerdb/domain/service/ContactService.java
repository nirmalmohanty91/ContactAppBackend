package com.cdk.customerdb.domain.service;

import com.cdk.customerdb.dto.CustomerRequestDto;
import com.cdk.customerdb.dto.CustomerResponseDto;

import java.util.List;

public interface ContactService {

   List<CustomerResponseDto> getCustomers();

   CustomerResponseDto createCustomer(CustomerRequestDto customerRequestDto);

}
