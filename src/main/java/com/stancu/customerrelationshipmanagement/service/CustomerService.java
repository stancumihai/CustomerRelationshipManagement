package com.stancu.customerrelationshipmanagement.service;

import com.stancu.customerrelationshipmanagement.model.Customer;

import java.util.List;


public interface CustomerService {

    List<Customer> getCustomers();

    void saveCustomer(Customer customer);

    Customer getCustomer(int id);

    void deleteCustomer(int theId);
}
