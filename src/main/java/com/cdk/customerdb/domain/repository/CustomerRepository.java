package com.cdk.customerdb.domain.repository;

import com.cdk.customerdb.domain.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity,Integer> {
}
