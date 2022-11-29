package com.niit.jdp.BEJ_C3_S1_SpringBoot_JWT_PC_1.repository;

import com.niit.jdp.BEJ_C3_S1_SpringBoot_JWT_PC_1.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    public Customer findByUsernameAndPassword(String customerName, String customerPassword);

}
