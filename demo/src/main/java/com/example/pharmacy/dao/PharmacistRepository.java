package com.example.pharmacy.dao;

import com.example.pharmacy.model.Pharmacist;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PharmacistRepository extends JpaRepository<Pharmacist, Long> {
    List<Pharmacist> findByName(String name);
    List<Pharmacist> findByLicenseNumber(String licenseNumber);
    List<Pharmacist> findByNameContainingIgnoreCase(String name);
    List<Pharmacist> findByLicenseNumberContainingIgnoreCase(String licenseNumber);
}