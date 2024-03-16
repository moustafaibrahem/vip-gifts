package com.promo.vipgifts.repository;

import com.promo.vipgifts.entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer,Integer> {
}
