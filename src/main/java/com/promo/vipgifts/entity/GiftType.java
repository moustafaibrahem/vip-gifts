package com.promo.vipgifts.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table("GIFT_TYPE")
public record GiftType(
        @Id Integer giftTypeId,
        String giftTypeName,
        String giftTypeDescription,
        boolean deleted,
        LocalDateTime deletedAt
) {
}
