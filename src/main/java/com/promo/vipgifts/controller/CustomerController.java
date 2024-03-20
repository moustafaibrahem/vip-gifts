package com.promo.vipgifts.controller;

import com.promo.vipgifts.dto.CustomerDto;
import com.promo.vipgifts.dto.GiftTypeDto;
import com.promo.vipgifts.entity.Customer;
import com.promo.vipgifts.entity.GiftType;
import com.promo.vipgifts.entity.RedeemedCustomerGift;
import com.promo.vipgifts.service.CustomerService;
import com.promo.vipgifts.service.GiftTypeService;
import com.promo.vipgifts.service.RedeemedCustomerGiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("customer")
public class CustomerController {
    private final CustomerService customerService;
    private final GiftTypeService giftTypeService;
    private final RedeemedCustomerGiftService redeemedCustomerGiftService;
    @Autowired
    public CustomerController(CustomerService customerService, GiftTypeService giftTypeService, RedeemedCustomerGiftService redeemedCustomerGiftService) {
        this.customerService = customerService;
        this.giftTypeService = giftTypeService;
        this.redeemedCustomerGiftService = redeemedCustomerGiftService;
    }
    @GetMapping("")
    public List<CustomerDto> getAllCustomersDTOs(){
        return customerService.getAllCustomersDTOs();
    }
    @GetMapping("/{phone}")
    public CustomerDto getCustomerByPhone(@PathVariable String phone){
        return customerService.getCustomerDtoByPhone(phone);
    }
    @GetMapping("/{phone}/all-gifts")
    public List<GiftTypeDto> getAllCustomerGiftTypesDTOs(@PathVariable String phone){
        return giftTypeService.getAllCustomerGiftTypesDTOs(phone);
    }
    @GetMapping("/{phone}/gift")
    public List<GiftTypeDto> getAvailableCustomerGiftTypesDTOs(@PathVariable String phone){
        return giftTypeService.getAvailableCustomerGiftTypesDTOs(phone);
    }
    @PostMapping("/{phone}/gift/{code}")
    public Boolean redeemGift(@PathVariable String phone, @PathVariable String code){
        Boolean flag = false;
        Optional<Customer> customer = customerService.getCustomerByPhone(phone);
        Optional<GiftType> giftType = giftTypeService.getGiftTypeByCode(code);
        if (customer.isPresent()&&giftType.isPresent()){
            Optional<RedeemedCustomerGift> redeemedCustomerGift = redeemedCustomerGiftService.getRedeemedCustomerGiftByCustomerIdAndGiftTypeId(customer.get().customerId(),giftType.get().giftTypeId());
            if (!redeemedCustomerGift.isPresent())
            {
                RedeemedCustomerGift savedRedeemedCustomerGift = redeemedCustomerGiftService.redeemGift(new RedeemedCustomerGift(null,customer.get().customerId(),giftType.get().giftTypeId(), LocalDateTime.now()));
                if (savedRedeemedCustomerGift!=null)
                    flag = true;
            }
        }
        return flag;
    }
    /**
     *
     * @param phone
     * @param code in this param please send with %23 in the end of it in api
     * @return true or false
     */
    @GetMapping("/{phone}/gift/{code}")
    public Boolean isGiftTypeTakenByCustomer(@PathVariable String phone, @PathVariable String code){
        return giftTypeService.isGiftTypeTakenByCustomer(phone,code);
    }
}
