package com.promo.vipgifts.repository;

import com.promo.vipgifts.entity.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends CrudRepository<Customer,Integer> {
    List<Customer> findAllByCustomerTypeId(Integer customerTypeId);
    Optional<Customer> findByCustomerPhone(String phone);
}
