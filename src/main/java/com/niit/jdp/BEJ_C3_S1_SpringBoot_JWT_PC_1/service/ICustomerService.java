package com.niit.jdp.BEJ_C3_S1_SpringBoot_JWT_PC_1.service;

import com.niit.jdp.BEJ_C3_S1_SpringBoot_JWT_PC_1.domain.Customer;

import java.util.List;

public interface ICustomerService {

    public Customer saveCustomer(Customer customer);

    public List<Customer> getAllCustomers();


}
