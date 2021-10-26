package com.example.customer.controller;

import com.example.customer.beans.CustomersDTO;
import com.example.customer.model.Customers;
import com.example.customer.repository.CustomersRepository;
import com.example.customer.service.CustomersService;
import com.example.customer.service.CustomersServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
class CustomersControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Mock
    private CustomersService customersService;

    @Mock
    private CustomersController customersController;


    private CustomersDTO customer;
    private Customers customers;


    /*@BeforeEach
    void setup(){

        //mockMvc = new MockMvc();
        customer = new CustomersDTO();
        customer.setName("user1");
        customer.setEmailid("user1@gmail.com");
        customer.setPhoneno("123456");
        customers= new Customers();
        customers.setId("344-4557-226hn44");
        customers.setName("user1");
        customers.setPhoneno("123456");
        customers.setEmailid("user1@gmail.com");
        //customersRepository.save(customers);
        //customersController= new CustomersController(customersService);
        //customersService.createCustomer(customer);
        //customersController.createCustomers(customer);
        mockMvc = MockMvcBuilders.standaloneSetup(customersController).build();*/


    //}

    @Test
    void testFindCustomersById() throws Exception{
        //given(customersService.createCustomer(customer)).willReturn(customers);
        mockMvc = MockMvcBuilders.standaloneSetup(customersController).build();
        given(customersService.findCustomersById("34444-4557-226hn")).willReturn(customer);
        mockMvc.perform(MockMvcRequestBuilders.get("/get/customers/34444-4557-226hn")).
                andExpect(MockMvcResultMatchers.jsonPath("$.name").value("user1")).
                andExpect(MockMvcResultMatchers.jsonPath("$.emailid").value("user1@gmail.com")).
                andExpect(MockMvcResultMatchers.jsonPath("$.phoneno").value("1234560")).
                andExpect((status().isOk()));


    }

   /* @Test
    void findCustomers() {
    }
    */

   /* @Test
    void createCustomers() {
        when(customersService.createCustomer(any(CustomersDTO.class))).thenReturn(customers);
        mockMvc.perform(post("/customers")).
                andExpect(status().isOk());
        //verify(customersService,times(1)).createCustomer(any());
    }*/
/*
    @Test
    void updateCustomers() {
    }

    @Test
    void deleteCustomers() {
    }
*/}