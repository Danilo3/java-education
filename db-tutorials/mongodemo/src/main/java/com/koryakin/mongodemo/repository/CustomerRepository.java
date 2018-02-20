package com.koryakin.mongodemo.repository;

import com.koryakin.mongodemo.domain.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CustomerRepository extends MongoRepository<Customer, String> {

    public Customer findCustomerByFirstName(String firstName);

    public List<Customer> findCustomersByLastName(String lastName);

}
