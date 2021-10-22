package com.example.customer.service;

import com.example.customer.beans.CustomersDTO;
import com.example.customer.model.Customers;

import java.util.List;

public interface CustomersService {

     Customers convertToCustomersEntity(CustomersDTO customer,String id);
     CustomersDTO convertToCustomersDTO(Customers customers);
     CustomersDTO findCustomersById(String id);
     List<CustomersDTO> findCustomers();
     Customers createCustomer(CustomersDTO customers);
     Customers updateCustomer(CustomersDTO customer,String id);
     void deleteCustomer(String id);
}
