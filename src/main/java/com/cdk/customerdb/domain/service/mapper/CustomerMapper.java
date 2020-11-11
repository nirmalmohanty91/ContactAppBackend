package com.cdk.customerdb.domain.service.mapper;

import com.cdk.customerdb.domain.entity.CustomerEntity;
import com.cdk.customerdb.dto.CustomerRequestDto;
import com.cdk.customerdb.dto.CustomerResponseDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

  @Value("${customer.service.source.code}")
  private String auditor;

  public static CustomerResponseDto buildCustomerResponse(CustomerEntity customerEntity) {
    return CustomerResponseDto.builder()
            .firstName(customerEntity.getFirstName())
            .lastName(customerEntity.getLastName())
            .build();
  }

  public CustomerEntity map(CustomerRequestDto customerRequestDto) {
    return CustomerEntity.builder()
            .firstName(customerRequestDto.getFirstName())
            .lastName(customerRequestDto.getLastName())
            .dateOfBirth(customerRequestDto.getDateOfBirth())
            .email(customerRequestDto.getEmail())
            .gender(customerRequestDto.getGender())
            .build();
  }
}
