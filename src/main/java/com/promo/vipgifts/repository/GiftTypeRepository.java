package com.promo.vipgifts.repository;

import com.promo.vipgifts.entity.GiftType;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GiftTypeRepository extends CrudRepository<GiftType,Integer> {
    @Query("select gt.*\n" +
            "from \"GIFT_TYPE\" gt\n" +
            "join \"CUSTOMER_TYPE_GIFT_TYPE\"ctgt ON ctgt.gift_type_id = gt.gift_type_id\n" +
            "join \"CUSTOMER_TYPE\" ct ON ct.customer_type_id = ctgt.customer_type_id\n" +
            "join \"CUSTOMER\" c ON c.customer_type_id = ct.customer_type_id\n" +
            "where c.customer_phone = :phone")
    List<GiftType> getAllGiftTypesByCustomerPhone(@Param("phone") String phone);
}
