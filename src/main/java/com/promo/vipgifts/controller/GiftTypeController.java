package com.promo.vipgifts.controller;

import com.promo.vipgifts.dto.GiftTypeDto;
import com.promo.vipgifts.entity.CustomerTypeGiftType;
import com.promo.vipgifts.service.CustomerTypeGiftTypeService;
import com.promo.vipgifts.service.GiftTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/gift-type")
public class GiftTypeController {
    private final GiftTypeService giftTypeService;
    private final CustomerTypeGiftTypeService customerTypeGiftTypeService;
    @Autowired
    public GiftTypeController(GiftTypeService giftTypeService, CustomerTypeGiftTypeService customerTypeGiftTypeService) {
        this.giftTypeService = giftTypeService;
        this.customerTypeGiftTypeService = customerTypeGiftTypeService;
    }
    @GetMapping("")
    public List<GiftTypeDto> getAllGiftTypesDTOs(){
        return giftTypeService.getAllGiftTypesDTOs();
    }
    @GetMapping("/{id}/customer-type")
    public List<CustomerTypeGiftType> getCustomerTypeGiftTypesByGiftTypeId(@PathVariable Integer id){
        return customerTypeGiftTypeService.getCustomerTypeGiftTypesByGiftTypeId(id);
    }
}
