package com.example.pharmacy.dao;

import com.example.pharmacy.model.Supplier;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    List<Supplier> findByName(String name);
    List<Supplier> findByContactInfo(String contactInfo);
    List<Supplier> findByNameContainingIgnoreCase(String name);
    List<Supplier> findByContactInfoContainingIgnoreCase(String contactInfo);
}