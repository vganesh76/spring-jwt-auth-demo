package com.roomy.shop.domain.repository;

import com.roomy.shop.domain.entity.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    void delete(Customer deleted);
    List<Customer> findAll();
    Optional<Customer> findById(Long id);
    Customer save(Customer persisted);
    Optional<Customer> findByEmail(String email);
    Optional<Customer> findByFirstName(String firstname);
    Optional<Customer> findByLastName(String lastname);
}
