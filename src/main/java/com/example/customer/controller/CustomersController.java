package com.example.customer.controller;

import com.example.customer.beans.CustomersDTO;
import com.example.customer.model.Customers;
import com.example.customer.service.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CustomersController {

    CustomersService customerService;

    CustomersController(CustomersService customerService){
       this.customerService=customerService;
    }

    @GetMapping("/get/customers/{id}")
    public CustomersDTO findCustomersById(@PathVariable String id){
        return customerService.findCustomersById(id);
    }

    @GetMapping("/get/customers")
    public List<CustomersDTO> findCustomers(){
        return customerService.findCustomers();
    }

    @PostMapping("/customers")
    public Customers createCustomers(@RequestBody CustomersDTO customer){
         return customerService.createCustomer(customer);
    }

    @PostMapping("/update/customers/{id}")
    public Customers updateCustomers(@RequestBody CustomersDTO customer,@PathVariable String id){
        return customerService.updateCustomer(customer,id);
    }

    @DeleteMapping("delete/customers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCustomers(@PathVariable String id){
        customerService.deleteCustomer(id);
    }

}
