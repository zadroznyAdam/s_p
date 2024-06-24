package com.example.pharmacy.dao;

import com.example.pharmacy.model.Prescription;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {
    List<Prescription> findByCustomerId(Long customerId);
    List<Prescription> findByStatus(String status);
    List<Prescription> findByCustomerIdAndStatus(Long customerId, String status);
}