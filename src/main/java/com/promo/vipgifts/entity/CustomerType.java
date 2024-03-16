package com.promo.vipgifts.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table("CUSTOMER_TYPE")
public record CustomerType(
        @Id Integer customerTypeId,
        String customerTypeName,
        String customerTypeDescription,
        boolean deleted,
        LocalDateTime deletedAt
        ) {
}
