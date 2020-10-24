package com.cdk.customerdb.controller;

import com.cdk.customerdb.domain.entity.CustomerEntity;
import com.cdk.customerdb.domain.service.ContactService;
import com.cdk.customerdb.model.Contact;
import io.micrometer.core.annotation.Timed;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("/v1")
@Slf4j
public class CustomerController {

  @Autowired
  private ContactService contactService;

  @Timed
  @GetMapping(path = "/customers")
  public ResponseEntity<List<CustomerEntity>> retrieveCustomers(@RequestHeader("trace-id") String traceId,
                                                               @RequestHeader("authorization") String authorization) {
    log.info("CustomerController:: retrieveCustomers() execution started for trace-id [{}]",traceId);
    List<CustomerEntity> customers = contactService.getCustomers();
    log.info("CustomerController:: retrieveCustomers() execution finished for trace-id [{}]",traceId);
    return ResponseEntity.of(Optional.ofNullable(customers));
  }

  @PostMapping(path = "/add-customer")
  public Contact createContact(@RequestBody Contact contact) {
    String uniqueID = UUID.randomUUID().toString();
    contact.setId(uniqueID);
    return contactService.createContact(contact);
  }

  @PostMapping(path = "deleteContact/{id}")
  public String deleteContact(@PathVariable("id") String id) {
    return contactService.deleteByID(id);
  }

  @PutMapping(path = "updateRecord")
  public Contact updateRecord(@RequestBody Contact contact) {
    return null;
  }

  // @GetMapping(path = "/getListByName/{name}")
  // public Contact getListByName(@PathVariable("name") String firstName) {
  // return contactService.getByName(firstName);
  //
  // }

}
