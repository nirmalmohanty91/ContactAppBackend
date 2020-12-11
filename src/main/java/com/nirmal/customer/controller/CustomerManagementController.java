package com.nirmal.customer.controller;

import com.nirmal.customer.dto.CustomerRequestDto;
import com.nirmal.customer.dto.CustomerResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("management/api/v1/customers")
@Slf4j
public class CustomerManagementController {

  List<CustomerResponseDto> customerList =
      Arrays.asList(
          CustomerResponseDto.builder().id(1).firstName("Nirmal").lastName("Mohanty").build());

  /** hasRole(), hasAnyRole(), hasAuthority(), hasAnyAuthority() */


  @GetMapping
  @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_ADMINTRAINEE')")
  public List<CustomerResponseDto> getAllCustomers(){
    log.info("CustomerManagementController:: getAllCustomers()");
    return customerList;
  }

  @PostMapping
  @PreAuthorize("hasAuthority('student:write')")
  public void registerNewCustomer(@RequestBody CustomerRequestDto customerRequestDto){
    log.info("CustomerManagementController:: registerNewCustomer() {[]}", "New customer created!");
  }

  @DeleteMapping(path="{customerId}")
  @PreAuthorize("hasAuthority('student:write')")
  public void deleteCustomer(@PathVariable("customerId") Integer customerId){
    log.info("CustomerManagementController:: deleteCustomer() {[]}", customerId);
  }

  @PutMapping(path="{customerId}")
  @PreAuthorize("hasAuthority('student:write')")
  public void updateCustomer(@PathVariable("customerId") Integer customerId, @RequestBody CustomerRequestDto customerRequestDto){
    log.info("CustomerManagementController:: updateCustomer() {[]}", customerId);
  }
}
