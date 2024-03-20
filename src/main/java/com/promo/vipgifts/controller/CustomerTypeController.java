package com.promo.vipgifts.controller;

import com.promo.vipgifts.dto.CustomerDto;
import com.promo.vipgifts.dto.CustomerTypeDto;
import com.promo.vipgifts.entity.CustomerType;
import com.promo.vipgifts.service.CustomerService;
import com.promo.vipgifts.service.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer-type")
public class CustomerTypeController {
    private final CustomerTypeService customerTypeService;
    private final CustomerService customerService;
    @Autowired
    public CustomerTypeController(CustomerTypeService customerTypeService,CustomerService customerService) {
        this.customerTypeService = customerTypeService;
        this.customerService = customerService;
    }

    @GetMapping("")
    public List<CustomerTypeDto> getAllCustomerTypesDTOs(){
        return customerTypeService.getAllCustomerTypesDTOs();
    }
    @GetMapping("/{id}")
    public CustomerTypeDto getCustomerType(@PathVariable("id") Integer id){
        return customerTypeService.getCustomerTypeDto(id);
    }
    @GetMapping("/{id}/customer")
    public List<CustomerDto> getCustomersWithCustomerTypeId(@PathVariable("id") Integer id){
        return customerService.getCustomersWithCustomerTypeId(id);
    }

}
