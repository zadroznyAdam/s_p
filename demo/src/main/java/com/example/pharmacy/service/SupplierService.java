package com.example.pharmacy.service;

import com.example.pharmacy.dao.SupplierRepository;
import com.example.pharmacy.model.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {
    @Autowired
    private SupplierRepository supplierRepository;

    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    public Supplier getSupplierById(Long id) {
        return supplierRepository.findById(id).orElse(null);
    }

    public Supplier createSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    public Supplier updateSupplier(Long id, Supplier supplierDetails) {
        Supplier supplier = supplierRepository.findById(id).orElse(null);
        if (supplier != null) {
            supplier.setName(supplierDetails.getName());
            supplier.setContactInfo(supplierDetails.getContactInfo());
            return supplierRepository.save(supplier);
        }
        return null;
    }

    public void deleteSupplier(Long id) {
        supplierRepository.deleteById(id);
    }

    public List<Supplier> getSuppliersByName(String name) {
        return supplierRepository.findByNameContainingIgnoreCase(name);
    }

    public List<Supplier> getSuppliersByContactInfo(String contactInfo) {
        return supplierRepository.findByContactInfoContainingIgnoreCase(contactInfo);
    }
}