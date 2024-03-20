package com.promo.vipgifts.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table("CUSTOMER_TYPE_GIFT_TYPE")
public record CustomerTypeGiftType(
        @Id Integer customerTypeGiftTypeId,
        Integer customerTypeId,
        Integer giftTypeId,
        LocalDateTime createdAt
) {
}
