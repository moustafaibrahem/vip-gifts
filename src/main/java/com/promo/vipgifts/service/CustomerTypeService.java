package com.promo.vipgifts.service;

import com.promo.vipgifts.dto.CustomerTypeDto;
import com.promo.vipgifts.entity.CustomerType;
import com.promo.vipgifts.repository.CustomerTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerTypeService {
    private final CustomerTypeRepository customerTypeRepository;
    @Autowired
    public CustomerTypeService(CustomerTypeRepository customerTypeRepository) {
        this.customerTypeRepository = customerTypeRepository;
    }
    private CustomerTypeDto mapToDto(CustomerType customerType){
        return  new CustomerTypeDto(customerType.customerTypeName(), customerType.customerTypeDescription());
    }
    public List<CustomerTypeDto> getAllCustomerTypesDTOs(){
        List<CustomerType> customerTypes = (List<CustomerType>) customerTypeRepository.findAll();
        return customerTypes.stream().map(this::mapToDto).collect(Collectors.toList());
    }
    public CustomerTypeDto getCustomerTypeDto(Integer id){
        Optional<CustomerType> customerTypeOptional = customerTypeRepository.findById(id);
        if (customerTypeOptional.isPresent())
            return mapToDto(customerTypeOptional.get());
        else
            return new CustomerTypeDto("","");
    }
}
