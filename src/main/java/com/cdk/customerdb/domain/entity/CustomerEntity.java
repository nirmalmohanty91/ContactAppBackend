package com.cdk.customerdb.domain.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer_information")
public class CustomerEntity {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "first_name")
    private String name;

}
