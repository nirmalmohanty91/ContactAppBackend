package com.nirmal.customer.domain.service;

import com.nirmal.customer.dto.CustomerRequestDto;
import com.nirmal.customer.dto.CustomerResponseDto;

import java.util.List;

public interface ContactService {

   List<CustomerResponseDto> getCustomers();

   CustomerResponseDto createCustomer(CustomerRequestDto customerRequestDto);

}
