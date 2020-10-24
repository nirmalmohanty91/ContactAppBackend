package com.cdk.customerdb.domain.service.impl;

import com.cdk.customerdb.domain.entity.CustomerEntity;
import com.cdk.customerdb.domain.repository.CustomerRepository;
import com.cdk.customerdb.domain.service.ContactService;
import com.cdk.customerdb.domain.service.mapper.ContactMapper;
import com.cdk.customerdb.model.Contact;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ContactServiceImpl implements ContactService {

  @Autowired
  private ContactMapper contactMapper;

  @Autowired
  private CustomerRepository customerRepository;

  @Override
  public List<CustomerEntity> getCustomers() {
    List<CustomerEntity> customers = customerRepository.findAll();
    return customers;
  }

  // @Override
  // public Contact getByName(String firstName) {
  // contact = contactMapper.getByName(firstName);
  // return contact;
  // }

  @Override
  public Contact createContact(Contact contact) {
    contactMapper.insertRecord(contact);
    contact = contactMapper.getByName(contact.getFname());
    return contact;
  }

  @Override
  public String deleteByID(String id) {

    boolean isdeleted = contactMapper.deleteRecordByID(id);

    if (isdeleted) return "Customer with id: " + id + " has been deleted from db";
    else return "Record not found in the DB for ID: " + id;
  }
}
