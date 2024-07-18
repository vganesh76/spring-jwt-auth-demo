package com.roomy.shop.controller;

import com.roomy.shop.dto.CustomerDTO;
import com.roomy.shop.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    @GetMapping("/customer/email/{email}")
    public CustomerDTO getCustomerByEmail(@PathVariable("email") String email) {
        CustomerDTO customerDTO = customerService.findCustomerByEmail(email);

        return  customerDTO;
    }

    @PostMapping("/customer")
    public ResponseEntity<CustomerDTO> addCustomer(@RequestBody CustomerDTO customerDTO) {
        CustomerDTO response = null;

        try {
            response = customerService.addCustomer(customerDTO);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseEntity.ok(response);
    }
}
