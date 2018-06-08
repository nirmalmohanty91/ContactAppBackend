package com.cdk.customerdb.web;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.cdk.customerdb.model.Contact;
import com.cdk.customerdb.service.ContactService;

@RestController
@CrossOrigin
public class CustomerController {

  @Autowired
  ContactService contactService;

  @GetMapping(path = "/getAllContacts")
  public List<Contact> getAllContacts() {
    return contactService.loadAllContacts();

  }

  @PostMapping(path = "createContact")
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
