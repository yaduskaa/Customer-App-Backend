package com.example.customer.service;

import com.example.customer.beans.CustomersDTO;
import com.example.customer.model.Customers;
import com.example.customer.repository.CustomersRepository;
import lombok.ToString;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


@DataMongoTest
@RunWith(SpringRunner.class)
class CustomersServiceImplTest {

    @Mock
    private CustomersRepository customersRepository;

    @Mock
    private CustomersServiceImpl customersService;

    private CustomersDTO customer;
    private Customers customers;

    @BeforeEach
    void setup(){
       // customersService= new CustomersServiceImpl();
        customer= new CustomersDTO();
        customer.setPhoneno("22");
        customer.setName("User");
        customer.setEmailid("user@gmail.com");
        customers= new Customers();
        customers.setName("User");
        customers.setId("1455-5450-4758");
        customers.setPhoneno("22");
        customers.setEmailid("user@gmail.com");
        customersRepository.save(customers);
         customersService= new CustomersServiceImpl(customersRepository);
    }


    @Test
    void convertToCustomersDTO() {
        assertEquals(customersService.convertToCustomersDTO(customers),customer);
    }


    @Test
    void convertToCustomersEntity() {
        assertEquals(customersService.convertToCustomersEntity(customer,"1455-5450-4758"),customers);
    }

    @Test
    void findCustomersById() {
        Mockito.when(customersRepository.findCustomersById("1455-5450-4758")).thenReturn(customers);
        assertEquals(customersService.findCustomersById("1455-5450-4758"),customer);
    }

   @Test
    void findCustomers() {
        ArrayList<Customers> customersList= new ArrayList<>();
        customersList.add(customers);
        Mockito.when(customersRepository.findAll()).thenReturn(customersList);
        assertEquals(customersService.findCustomers().get(0),customer);

    }

   @Test
    void createCustomer() {
        Customers customers2= new Customers();
        customers2.setId("4355-7664-836yh");
        customers2.setName("User2");
        customers2.setEmailid("user2@gmail.com");
        customers2.setPhoneno("356478892");
        CustomersDTO customer2= new CustomersDTO();
        customer2.setName("User2");
        customer2.setEmailid("user2@gmail.com");
        customer2.setPhoneno("356478892");
        Mockito.when(customersRepository.save(any(Customers.class))).thenReturn(customers2);
        customersService.createCustomer(customer2);
        verify(customersRepository,times(2)).save(any(Customers.class));


    }

   @Test
    void updateCustomer() {
     customers.setEmailid("userupdated@gmail.com");
     customer.setEmailid("userupdated@gmail.com");
     Mockito.when(customersRepository.save(customers)).thenReturn(customers);
     assertEquals(customersService.updateCustomer(customer,customers.getId()),customers);
     //verify(customersRepository).save(customers);
    }

    @Test
    void deleteCustomer() {
        customersService.deleteCustomer("1455-5450-4758");
        verify(customersRepository).deleteById("1455-5450-4758");
    }

    @AfterEach
    public void tearDown() {
        customersRepository.deleteAll();
        customers = null;
        customer = null;
    }


}