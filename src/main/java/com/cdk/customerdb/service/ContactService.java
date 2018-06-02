package com.cdk.customerdb.service;

import java.util.List;
import com.cdk.customerdb.model.Contact;

public interface ContactService {

  public List<Contact> loadAllContacts();

  public Contact getByName(String firstName);

  public Contact createContact(Contact contact);

  public String deleteByID(String id);

}
