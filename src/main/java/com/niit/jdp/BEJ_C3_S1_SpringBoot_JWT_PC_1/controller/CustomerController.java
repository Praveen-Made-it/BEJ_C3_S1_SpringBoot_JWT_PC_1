/*
 *Author Name:Praveen Kumar
 *Date: 29-Nov-22
 *Created With IntelliJ Idea Community Edition
 */


package com.niit.jdp.BEJ_C3_S1_SpringBoot_JWT_PC_1.controller;

import com.niit.jdp.BEJ_C3_S1_SpringBoot_JWT_PC_1.domain.Customer;
import com.niit.jdp.BEJ_C3_S1_SpringBoot_JWT_PC_1.exception.CustomerAlreadyExistsException;
import com.niit.jdp.BEJ_C3_S1_SpringBoot_JWT_PC_1.exception.CustomerNotFoundException;
import com.niit.jdp.BEJ_C3_S1_SpringBoot_JWT_PC_1.service.ICustomerService;
import com.niit.jdp.BEJ_C3_S1_SpringBoot_JWT_PC_1.service.SecurityTokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

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

    @GetMapping("/login")
    public ResponseEntity<?> loginfunction1(@RequestBody Customer customer) throws CustomerNotFoundException {

        try {
            customerService.validateLogin(customer.getCustomerName(), customer.getCustomerPassword());
            Map<String, String> secretKey = new HashMap<>();
            secretKey = securityTokenGenerator.generateToken(customer);
            return new ResponseEntity<>(secretKey, HttpStatus.OK);

        } catch (CustomerNotFoundException exception) {
            throw new CustomerNotFoundException();
        } catch (Exception exception) {
            return new ResponseEntity<>("Network Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

