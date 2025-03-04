package com.example.demo.repositories;

import com.example.demo.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findByEmailAddressIgnoreCase(String emailAddress);
}