/*
 *Author Name:Praveen Kumar
 *Date: 29-Nov-22
 *Created With IntelliJ Idea Community Edition
 */


package com.niit.jdp.BEJ_C3_S1_SpringBoot_JWT_PC_1.service;


import com.niit.jdp.BEJ_C3_S1_SpringBoot_JWT_PC_1.domain.Customer;
import com.niit.jdp.BEJ_C3_S1_SpringBoot_JWT_PC_1.exception.CustomerAlreadyExistsException;
import com.niit.jdp.BEJ_C3_S1_SpringBoot_JWT_PC_1.exception.CustomerNotFoundException;
import com.niit.jdp.BEJ_C3_S1_SpringBoot_JWT_PC_1.service.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService {
    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer saveCustomer(Customer customer) throws CustomerAlreadyExistsException {
        if (customerRepository.findById(customer.getCustomerId()).isPresent()) {
            throw new CustomerAlreadyExistsException();
        }
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer validateLogin(String customerName, String customerPassword) throws CustomerNotFoundException {
        Customer customerObj = customerRepository.findByCustomerNameAndCustomerPassword(customerName, customerPassword);
        if (customerObj == null) {
            throw new CustomerNotFoundException();
        }
        return customerObj;
    }

    @Override
    public boolean deleteCustomer(int CustomerId) throws CustomerNotFoundException {
        boolean flag = false;
        if (customerRepository.findById(CustomerId).isEmpty()) {
            throw new CustomerNotFoundException();
        } else {
            customerRepository.deleteById(CustomerId);
            flag = true;
        }
        return flag;
    }
}
