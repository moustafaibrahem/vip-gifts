package com.promo.vipgifts.controller;

import com.promo.vipgifts.dto.GiftTypeDto;
import com.promo.vipgifts.service.GiftTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/gift-type")
public class GiftTypeController {
    private final GiftTypeService giftTypeService;
    @Autowired
    public GiftTypeController(GiftTypeService giftTypeService) {
        this.giftTypeService = giftTypeService;
    }
    @GetMapping("")
    public List<GiftTypeDto> getAllGiftTypesDTOs(){
        return giftTypeService.getAllGiftTypesDTOs();
    }
}
