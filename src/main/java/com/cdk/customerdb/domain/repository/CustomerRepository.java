package com.cdk.customerdb.domain.repository;

import com.cdk.customerdb.domain.entity.CustomerEntityTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntityTest,Integer> {
}
