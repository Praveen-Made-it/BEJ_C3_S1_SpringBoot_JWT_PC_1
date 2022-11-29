package com.niit.jdp.BEJ_C3_S1_SpringBoot_JWT_PC_1.service;

import com.niit.jdp.BEJ_C3_S1_SpringBoot_JWT_PC_1.domain.Customer;
import com.niit.jdp.BEJ_C3_S1_SpringBoot_JWT_PC_1.exception.CustomerAlreadyExistsException;

import java.util.List;

public interface ICustomerService {

    public Customer saveCustomer(Customer customer) throws CustomerAlreadyExistsException;

    public List<Customer> getAllCustomers();

    public Customer validateLogin(String customerName, String customerPassword);

    boolean deleteCustomer(int CustomerId);
}
