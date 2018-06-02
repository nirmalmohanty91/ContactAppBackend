package com.cdk.customerdb.model;

import org.springframework.stereotype.Component;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Component
public class Contact { 

  private String id;
  private String fname;
  private String lname;
  private String address;

}
