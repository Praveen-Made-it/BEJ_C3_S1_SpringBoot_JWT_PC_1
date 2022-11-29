/*
 *Author Name:Praveen Kumar
 *Date: 29-Nov-22
 *Created With IntelliJ Idea Community Edition
 */


package com.niit.jdp.BEJ_C3_S1_SpringBoot_JWT_PC_1.controller;

import com.niit.jdp.BEJ_C3_S1_SpringBoot_JWT_PC_1.service.ICustomerService;
import com.niit.jdp.BEJ_C3_S1_SpringBoot_JWT_PC_1.service.SecurityTokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
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
}
