package com.niit.jdp.BEJ_C3_S1_SpringBoot_JWT_PC_1.service.repository;

import com.niit.jdp.BEJ_C3_S1_SpringBoot_JWT_PC_1.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    public Customer findByCustomerNameAndCustomerPassword(String customerName, String customerPassword);

}
