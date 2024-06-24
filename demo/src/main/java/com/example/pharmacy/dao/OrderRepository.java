package com.example.pharmacy.dao;

import com.example.pharmacy.model.Order;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByStatus(String status);
    List<Order> findByPharmacistId(Long pharmacistId);
    List<Order> findByOrderDateBetween(Date startDate, Date endDate);
}