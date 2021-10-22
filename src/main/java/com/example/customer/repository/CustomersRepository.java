package com.example.customer.repository;

import com.example.customer.model.Customers;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface CustomersRepository extends MongoRepository<Customers,String> {
    @Query("{'id':?0}")
    public Customers findCustomersById(String id);

}
