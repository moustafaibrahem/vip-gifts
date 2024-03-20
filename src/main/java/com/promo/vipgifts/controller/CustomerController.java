package com.promo.vipgifts.controller;

import com.promo.vipgifts.dto.CustomerDto;
import com.promo.vipgifts.dto.GiftTypeDto;
import com.promo.vipgifts.service.CustomerService;
import com.promo.vipgifts.service.GiftTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("customer")
public class CustomerController {
    private final CustomerService customerService;
    private final GiftTypeService giftTypeService;
    @Autowired
    public CustomerController(CustomerService customerService, GiftTypeService giftTypeService) {
        this.customerService = customerService;
        this.giftTypeService = giftTypeService;
    }

    @GetMapping("")
    public List<CustomerDto> getAllCustomersDTOs(){
        return customerService.getAllCustomersDTOs();
    }
    @GetMapping("/{phone}")
    public CustomerDto getCustomerByPhone(@PathVariable String phone){
        return customerService.getCustomerDtoByPhone(phone);
    }
    @GetMapping("/{phone}/gift")
    public List<GiftTypeDto> getAllCustomerGiftTypesDTOs(@PathVariable String phone){
        return giftTypeService.getAllCustomerGiftTypesDTOs(phone);
    }
}
