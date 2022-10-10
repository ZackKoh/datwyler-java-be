package com.zackk.datwyler.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zackk.datwyler.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
