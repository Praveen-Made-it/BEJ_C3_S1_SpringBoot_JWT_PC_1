package com.niit.jdp.BEJ_C3_S1_SpringBoot_JWT_PC_1.service;

import com.niit.jdp.BEJ_C3_S1_SpringBoot_JWT_PC_1.domain.Customer;

import java.util.Map;

public interface SecurityTokenGenerator {
    Map<String, String> generateToken(Customer customer);
}
