package com.promo.vipgifts.controller;

import com.promo.vipgifts.dto.CustomerDto;
import com.promo.vipgifts.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("customer")
public class CustomerController {
    private final CustomerService customerService;
    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @GetMapping("")
    public List<CustomerDto> getAllCustomersDTOs(){
        return customerService.getAllCustomersDTOs();
    }
}
