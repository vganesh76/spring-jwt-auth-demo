package com.roomy.shop.domain.repository;

import com.roomy.shop.domain.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    void delete(User deleted);
    List<User> findAll();
    Optional<User> findById(Long id);
    User save(User persisted);
    Optional<User> findByEmail(String email);
}
