/*
 *Author Name:Praveen Kumar
 *Date: 29-Nov-22
 *Created With IntelliJ Idea Community Edition
 */


package com.niit.jdp.BEJ_C3_S1_SpringBoot_JWT_PC_1.controller;

import com.niit.jdp.BEJ_C3_S1_SpringBoot_JWT_PC_1.domain.Customer;
import com.niit.jdp.BEJ_C3_S1_SpringBoot_JWT_PC_1.exception.CustomerAlreadyExistsException;
import com.niit.jdp.BEJ_C3_S1_SpringBoot_JWT_PC_1.service.ICustomerService;
import com.niit.jdp.BEJ_C3_S1_SpringBoot_JWT_PC_1.service.SecurityTokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    private ICustomerService customerService;
    private SecurityTokenGenerator securityTokenGenerator;

    @Autowired
    public CustomerController(ICustomerService customerService, SecurityTokenGenerator securityTokenGenerator) {
        this.customerService = customerService;
        this.securityTokenGenerator = securityTokenGenerator;
    }

    @PostMapping("/register")
    public ResponseEntity<?> savefunction(@RequestBody Customer customer) throws CustomerAlreadyExistsException {
        return new ResponseEntity<>(customerService.saveCustomer(customer), HttpStatus.CREATED);
    }


}

