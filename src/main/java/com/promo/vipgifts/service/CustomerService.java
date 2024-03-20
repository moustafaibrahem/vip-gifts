package com.promo.vipgifts.service;

import com.promo.vipgifts.dto.CustomerDto;
import com.promo.vipgifts.entity.Customer;
import com.promo.vipgifts.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    public Optional<Customer> getCustomer(Integer id){
        return customerRepository.findById(id);
    }
    public Optional<Customer> getCustomerByPhone(String phone){
        return customerRepository.findByCustomerPhone(phone);
    }
    private CustomerDto mapToDto(Customer customer){
        return new CustomerDto(customer.customerName(), customer.customerPhone());
    }
    public List<CustomerDto> getAllCustomersDTOs(){
        List<Customer> customers = (List<Customer>) customerRepository.findAll();
        return customers.stream().map(this::mapToDto).collect(Collectors.toList());
    }
    public CustomerDto getCustomerDtoByPhone(String phone){
        Optional<Customer> customer = customerRepository.findByCustomerPhone(phone);
        return customer.map(this::mapToDto).orElseGet(() -> new CustomerDto("", ""));
    }
    public List<CustomerDto> getCustomersWithCustomerTypeId(Integer customerTypeId){
        List<Customer> customers = customerRepository.findAllByCustomerTypeId(customerTypeId);
        return customers.stream().map(this::mapToDto).collect(Collectors.toList());
    }
}
