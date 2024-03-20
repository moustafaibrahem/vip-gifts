package com.promo.vipgifts.service;

import com.promo.vipgifts.entity.CustomerTypeGiftType;
import com.promo.vipgifts.repository.CustomerTypeGiftTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTypeGiftTypeService {
    private final CustomerTypeGiftTypeRepository customerTypeGiftTypeRepository;
    @Autowired
    public CustomerTypeGiftTypeService(CustomerTypeGiftTypeRepository customerTypeGiftTypeRepository) {
        this.customerTypeGiftTypeRepository = customerTypeGiftTypeRepository;
    }
    //get CustomerTypeGiftTypes By giftTypeId
    public List<CustomerTypeGiftType> getCustomerTypeGiftTypesByGiftTypeId(Integer id){
        return customerTypeGiftTypeRepository.findCustomerTypeGiftTypesByGiftTypeId(id);
    }
}
