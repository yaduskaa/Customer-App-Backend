package com.example.customer.service;

import com.example.customer.beans.CustomersDTO;
import com.example.customer.model.Customers;
import com.example.customer.repository.CustomersRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class CustomersServiceImpl implements CustomersService {

    CustomersRepository customerRepo;

    CustomersServiceImpl(CustomersRepository customerRepo){
        this.customerRepo=customerRepo;
    }

    @Override
    public CustomersDTO convertToCustomersDTO(Customers customers){
        CustomersDTO customer= new CustomersDTO();
        customer.setName(customers.getName());
        customer.setEmailid(customers.getEmailid());
        customer.setPhoneno(customers.getPhoneno());
        return customer;

    }

    @Override
    public Customers convertToCustomersEntity(CustomersDTO customer,String id){
        Customers customers= new Customers();
        customers.setId(id);
        customers.setName(customer.getName());
        customers.setEmailid(customer.getEmailid());
        customers.setPhoneno(customer.getPhoneno());
        return customers;

    }

    @Override
    public CustomersDTO findCustomersById(String id){
        CustomersDTO customer= new CustomersDTO();
        Customers customers= new Customers();
        customer.setName(customers.getName());
        customer.setEmailid(customers.getEmailid());
        customer.setPhoneno(customers.getPhoneno());
        return convertToCustomersDTO(customerRepo.findCustomersById(id));
    }
    public List<CustomersDTO> findCustomers(){
        ArrayList<CustomersDTO> customer= new ArrayList<>();

        for(Customers customers:customerRepo.findAll()){
            customer.add(convertToCustomersDTO(customers));
        }
        return customer;
    }
    public Customers createCustomer(CustomersDTO customer){
       return customerRepo.save(
               convertToCustomersEntity(customer,UUID.randomUUID().toString()));
    }
    public Customers updateCustomer(CustomersDTO customer,String id){
        return customerRepo.save(
                convertToCustomersEntity(customer,id));

    }
    public void deleteCustomer(String id){
        customerRepo.deleteById(id);
    }
}
