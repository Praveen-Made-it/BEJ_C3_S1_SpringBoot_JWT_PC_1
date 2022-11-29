/*
 *Author Name:Praveen Kumar
 *Date: 29-Nov-22
 *Created With IntelliJ Idea Community Edition
 */


package com.niit.jdp.BEJ_C3_S1_SpringBoot_JWT_PC_1.domain;

import javax.persistence.Entity;

@Entity
public class Customer {

    private int customerId;

    private String customerName;

    private String customerPassword;

    private long customerPhoneNumber;


}
