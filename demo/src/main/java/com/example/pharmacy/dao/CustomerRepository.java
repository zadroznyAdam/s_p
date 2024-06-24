package com.example.pharmacy.dao;

import com.example.pharmacy.model.Customer;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByName(String name);
    List<Customer> findByEmail(String email);
    @Query("SELECT c FROM Customer c WHERE c.name LIKE %:name%")
    List<Customer> searchByName(@Param("name") String name);
}
