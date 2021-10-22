package com.example.customer.beans;

import lombok.Data;

import java.io.Serializable;

@Data
public class CustomersDTO implements Serializable {
    private String name;
    private String phoneno;
    private String emailid;
}
