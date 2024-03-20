package com.promo.vipgifts.service;

import com.promo.vipgifts.entity.RedeemedCustomerGift;
import com.promo.vipgifts.repository.RedeemedCustomerGiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RedeemedCustomerGiftService {
    private final RedeemedCustomerGiftRepository redeemedCustomerGiftRepository;
    @Autowired
    public RedeemedCustomerGiftService(RedeemedCustomerGiftRepository redeemedCustomerGiftRepository) {
        this.redeemedCustomerGiftRepository = redeemedCustomerGiftRepository;

    }
    public RedeemedCustomerGift redeemGift(RedeemedCustomerGift redeemedCustomerGift){
        return redeemedCustomerGiftRepository.save(redeemedCustomerGift);
    }
    public Optional<RedeemedCustomerGift> getRedeemedCustomerGiftByCustomerIdAndGiftTypeId(Integer customerId,Integer giftTypeId){
        return redeemedCustomerGiftRepository.findRedeemedCustomerGiftByCustomerIdAndGiftTypeId(customerId,giftTypeId);
    }

}
