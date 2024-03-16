package com.promo.vipgifts.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table("CUSTOMER")
public record Customer(
        @Id Integer customerId,
        String customerName,
        String customerPhone,
        Integer customerTypeId,
        boolean deleted,
        LocalDateTime deletedAt
        ) {


}
