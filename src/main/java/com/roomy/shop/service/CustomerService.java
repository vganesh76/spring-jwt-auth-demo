package com.roomy.shop.service;

import com.roomy.shop.dto.CustomerDTO;

public interface CustomerService {

    CustomerDTO findCustomerByEmail(String email);
    CustomerDTO addCustomer(CustomerDTO customerDTOIn);
}
