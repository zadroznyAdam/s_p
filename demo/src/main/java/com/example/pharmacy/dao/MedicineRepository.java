package com.example.pharmacy.dao;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.pharmacy.model.Medicine;

import java.util.List;

public interface MedicineRepository extends JpaRepository<Medicine, Long> {

    @Query("SELECT m FROM Medicine m WHERE " +
           "(:name IS NULL OR m.name LIKE %:name%) AND " +
           "(:manufacturer IS NULL OR m.manufacturer LIKE %:manufacturer%) AND " +
           "(:supplierId IS NULL OR m.supplier.id = :supplierId)")
    List<Medicine> findByFilter(
        @Param("name") String name,
        @Param("manufacturer") String manufacturer,
        @Param("supplierId") Long supplierId);

List<Medicine> findAll(Sort sort);

List<Medicine> findByNameContainingIgnoreCase(String name);
List<Medicine> findByManufacturerContainingIgnoreCase(String manufacturer);
}

