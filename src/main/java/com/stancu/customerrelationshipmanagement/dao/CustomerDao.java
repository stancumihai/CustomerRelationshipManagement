package com.stancu.customerrelationshipmanagement.dao;

import com.stancu.customerrelationshipmanagement.model.Customer;

import java.util.List;

public interface CustomerDao {

    List<Customer> getCustomers();

    void saveCustomer(Customer customer);

    Customer getCustomer(int id);

    void deleteCustomer(int theId);
}
