package com.cdk.customerdb.domain.service;

import com.cdk.customerdb.domain.entity.CustomerEntity;
import com.cdk.customerdb.model.Contact;

import java.util.List;

public interface ContactService {

   List<CustomerEntity> getCustomers();

  // public Contact getByName(String firstName);

  public Contact createContact(Contact contact);

  public String deleteByID(String id);

}
