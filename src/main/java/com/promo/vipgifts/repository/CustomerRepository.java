package com.promo.vipgifts.repository;

import com.promo.vipgifts.entity.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer,Integer> {
    List<Customer> findAllByCustomerTypeId(Integer customerTypeId);
}
