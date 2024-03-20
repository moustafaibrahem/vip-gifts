package com.promo.vipgifts.repository;

import com.promo.vipgifts.entity.RedeemedCustomerGift;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RedeemedCustomerGiftRepository extends CrudRepository<RedeemedCustomerGift,Integer> {
    Optional<RedeemedCustomerGift> findRedeemedCustomerGiftByCustomerIdAndGiftTypeId(Integer customerId,Integer giftTypeId);
}
