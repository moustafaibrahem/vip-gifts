package com.promo.vipgifts.repository;

import com.promo.vipgifts.entity.CustomerTypeGiftType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerTypeGiftTypeRepository extends CrudRepository<CustomerTypeGiftType,Integer> {
    List<CustomerTypeGiftType> findCustomerTypeGiftTypesByGiftTypeId(Integer id);
    List<CustomerTypeGiftType> findCustomerTypeGiftTypesByCustomerTypeId(Integer id);
}
