package com.roomy.shop.service;

import com.roomy.shop.domain.entity.Customer;
import com.roomy.shop.domain.repository.CustomerRepository;
import com.roomy.shop.dto.CustomerDTO;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
@Slf4j
public class CustomerServiceImpl implements  CustomerService {
    private CustomerRepository customerRepository;
    private ModelMapper modelMapper;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, ModelMapper modelMapper) {
       this.customerRepository = customerRepository;
       this.modelMapper = modelMapper;
    }
    @Override
    public CustomerDTO findCustomerByEmail(String email) {
        Optional<Customer> customerOptional = customerRepository.findByEmail(email);

        if(customerOptional.isPresent()) {
            Customer customer = customerOptional.get();
            CustomerDTO customerDTO = modelMapper.map(customer, CustomerDTO.class);

            return customerDTO;
        }
        return null;
    }

    public CustomerDTO addCustomer(CustomerDTO customerDTOIn) {
        Customer customer = modelMapper.map(customerDTOIn, Customer.class);
        if(customer.getCreatedOn() == null) customer.setCreatedOn(new Date());
        customer = customerRepository.save(customer);
        CustomerDTO customerDTOOut = modelMapper.map(customer, CustomerDTO.class);

        log.info("*** return new Customer ***");
        return customerDTOOut;
    }
}
