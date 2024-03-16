package com.promo.vipgifts.controller;

import com.promo.vipgifts.dto.CustomerTypeDto;
import com.promo.vipgifts.entity.CustomerType;
import com.promo.vipgifts.repository.CustomerTypeRepository;
import com.promo.vipgifts.service.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customer-type")
public class CustomerTypeController {
    private final CustomerTypeService customerTypeService;
    @Autowired
    public CustomerTypeController(CustomerTypeService customerTypeService) {
        this.customerTypeService = customerTypeService;
    }

    @GetMapping("")
    public List<CustomerTypeDto> getAllCustomerTypes(){
        return customerTypeService.getAllCustomerTypesDTOs();
    }

}
