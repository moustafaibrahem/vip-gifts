package com.promo.vipgifts.repository;

import com.promo.vipgifts.entity.GiftType;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface GiftTypeRepository extends CrudRepository<GiftType,Integer> {
    Optional<GiftType> findByGiftTypeCode(String code);
    @Query("select gt.*\n" +
            "from \"GIFT_TYPE\" gt\n" +
            "join \"CUSTOMER_TYPE_GIFT_TYPE\"ctgt ON ctgt.gift_type_id = gt.gift_type_id\n" +
            "join \"CUSTOMER_TYPE\" ct ON ct.customer_type_id = ctgt.customer_type_id\n" +
            "join \"CUSTOMER\" c ON c.customer_type_id = ct.customer_type_id\n" +
            "where c.customer_phone = :phone")
    List<GiftType> getAllGiftTypesByCustomerPhone(@Param("phone") String phone);
    @Query("SELECT DISTINCT gt.*\n" +
            "FROM public.\"GIFT_TYPE\" gt\n" +
            "INNER JOIN public.\"CUSTOMER_TYPE_GIFT_TYPE\" ctgt ON gt.gift_type_id = ctgt.gift_type_id\n" +
            "INNER JOIN public.\"CUSTOMER_TYPE\" ct ON ctgt.customer_type_id = ct.customer_type_id\n" +
            "INNER JOIN public.\"CUSTOMER\" c ON ct.customer_type_id = c.customer_type_id\n" +
            "LEFT JOIN public.\"REDEEMED_CUSTOMER_GIFT\" rcg ON gt.gift_type_id = rcg.gift_type_id AND c.customer_id = rcg.customer_id\n" +
            "WHERE c.customer_phone = :phone \n" +
            "AND rcg.gift_type_id IS NULL;\n")
    List<GiftType> getAvailableGiftTypesByCustomerPhone(@Param("phone") String phone);
    @Query("SELECT count(gt.gift_type_id)\n" +
            "FROM public.\"CUSTOMER\" c\n" +
            "INNER JOIN public.\"REDEEMED_CUSTOMER_GIFT\" rcg ON c.customer_id = rcg.customer_id\n" +
            "INNER JOIN public.\"GIFT_TYPE\" gt ON rcg.gift_type_id = gt.gift_type_id\n" +
            "WHERE c.customer_phone = :phone \n" +
            "AND gt.gift_type_code = :code ;\n")
    Boolean isGiftTypeTakenByCustomer(@Param("phone") String phone,@Param("code")String code);

}
