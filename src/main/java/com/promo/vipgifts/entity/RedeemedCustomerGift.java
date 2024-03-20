package com.promo.vipgifts.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
@Table("REDEEMED_CUSTOMER_GIFT")
public record RedeemedCustomerGift(
        @Id Integer redeemedCustomerGiftId,
        Integer customerId,
        Integer giftTypeId,
        LocalDateTime createdAt
) {
}
