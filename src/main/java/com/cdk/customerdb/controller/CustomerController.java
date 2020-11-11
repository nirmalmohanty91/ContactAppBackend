package com.cdk.customerdb.controller;

import com.cdk.customerdb.domain.service.ContactService;
import com.cdk.customerdb.dto.CustomerRequestDto;
import com.cdk.customerdb.dto.CustomerResponseDto;
import io.micrometer.core.annotation.Timed;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1")
@Slf4j
public class CustomerController {

  @Autowired
  private ContactService contactService;

  @Timed
  @GetMapping(path = "/customers")
  @PreAuthorize("")
  public ResponseEntity<List<CustomerResponseDto>> retrieveCustomers(@RequestHeader("trace-id") String traceId,
                                                                @RequestHeader("authorization") String authorization) {
    log.info("CustomerController:: retrieveCustomers() execution started for trace-id [{}]",traceId);
    List<CustomerResponseDto> customers = contactService.getCustomers();
    log.info("CustomerController:: retrieveCustomers() execution finished for trace-id [{}]",traceId);
    return ResponseEntity.of(Optional.ofNullable(customers));
  }

  @Timed
  @PostMapping(path = "/create-customer")
  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<CustomerResponseDto> createCustomer(
      @RequestHeader("trace-id") String traceId,
      @RequestHeader("authorization") String authorization,
      @RequestBody @Valid CustomerRequestDto customerRequestDto) {
    log.info("CustomerController:: retrieveCustomers() execution started for trace-id [{}]",traceId);
    CustomerResponseDto customer = contactService.createCustomer(customerRequestDto);
    log.info("CustomerController:: retrieveCustomers() execution finished for trace-id [{}]",traceId);
    return ResponseEntity.of(Optional.ofNullable(customer));
  }
}
