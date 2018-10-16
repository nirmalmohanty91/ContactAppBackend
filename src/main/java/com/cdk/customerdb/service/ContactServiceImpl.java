package com.cdk.customerdb.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cdk.customerdb.mapper.ContactMapper;
import com.cdk.customerdb.model.Contact;

@Service
public class ContactServiceImpl implements ContactService {

  @Autowired ContactMapper contactMapper;

  @Autowired Contact contact;

  @Override
  public List<Contact> loadAllContacts() {
    List<Contact> list = new ArrayList<>();
    list = contactMapper.getAll();
    return list;
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
