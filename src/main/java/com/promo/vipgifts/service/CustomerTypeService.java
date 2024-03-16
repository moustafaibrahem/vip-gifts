package com.promo.vipgifts.service;

import com.promo.vipgifts.dto.CustomerTypeDto;
import com.promo.vipgifts.entity.CustomerType;
import com.promo.vipgifts.repository.CustomerTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerTypeService {
    private CustomerTypeRepository customerTypeRepository;
    @Autowired
    public CustomerTypeService(CustomerTypeRepository customerTypeRepository) {
        this.customerTypeRepository = customerTypeRepository;
    }
    private CustomerTypeDto mapToDto(CustomerType customerType){
        CustomerTypeDto customerTypeDto = new CustomerTypeDto(customerType.customerTypeName(), customerType.customerTypeDescription());
        return customerTypeDto;
    }

    public List<CustomerTypeDto> getAllCustomerTypes(){
        List<CustomerType> customerTypes = (List<CustomerType>) customerTypeRepository.findAll();
        return customerTypes.stream().map(this::mapToDto).collect(Collectors.toList());
    }
}
