package com.cdk.customerdb.domain.service.impl;

import com.cdk.customerdb.domain.entity.CustomerEntity;
import com.cdk.customerdb.domain.repository.CustomerRepository;
import com.cdk.customerdb.domain.service.ContactService;
import com.cdk.customerdb.domain.service.mapper.CustomerMapper;
import com.cdk.customerdb.dto.CustomerRequestDto;
import com.cdk.customerdb.dto.CustomerResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ContactServiceImpl implements ContactService {

  @Autowired private CustomerRepository customerRepository;

  @Autowired private CustomerMapper customerMapper;

  @Override
  public List<CustomerResponseDto> getCustomers() {
    log.info("ContactServiceImpl:: getCustomers() execution started");

    List<CustomerEntity> customerEntity = customerRepository.findAll();

    List<CustomerResponseDto> customers = new ArrayList<>();

    if (!customerEntity.isEmpty()) {
      customers =
          customerEntity.stream()
              .map(CustomerMapper::buildCustomerResponse)
              .collect(Collectors.toList());
    }
    log.info("ContactServiceImpl:: getCustomers() execution finished");
    return customers;
  }

  @Override
  public CustomerResponseDto createCustomer(CustomerRequestDto customerRequestDto) {

    CustomerEntity customer = customerMapper.map(customerRequestDto);
    customer = customerRepository.save(customer);

    CustomerResponseDto customerResponseDto = customerMapper.buildCustomerResponse(customer);

    return customerResponseDto;
  }
}
