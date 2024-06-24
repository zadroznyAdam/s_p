package com.example.pharmacy.service;

import com.example.pharmacy.dao.MedicineRepository;
import com.example.pharmacy.dao.SupplierRepository;
import com.example.pharmacy.model.Medicine;
import com.example.pharmacy.model.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class MedicineService {
    private static final Logger LOGGER = Logger.getLogger(MedicineService.class.getName());

    @Autowired
    private MedicineRepository medicineRepository;

    @Autowired
    private SupplierRepository supplierRepository;

    public List<Medicine> getAllMedicines(String sortBy, String sortDirection) {
        try {
            Sort sort = Sort.by(sortBy != null ? sortBy : "id");
            sort = sortDirection != null && sortDirection.equalsIgnoreCase("desc") ? sort.descending() : sort.ascending();
            LOGGER.info("Fetching all medicines with sorting by " + sortBy + " in " + sortDirection + " order");
            return medicineRepository.findAll(sort);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error fetching medicines", e);
            throw new RuntimeException("Error fetching medicines", e);
        }
    }

   

    public List<Medicine> getMedicinesByFilter(String name, String manufacturer, Long supplierId) {
        return medicineRepository.findByFilter(name, manufacturer, supplierId);
    }

    public Medicine getMedicineById(Long id) {
        return medicineRepository.findById(id).orElse(null);
    }

    public Medicine createMedicine(Medicine medicine) {
        try {
            if (medicine.getSupplier() != null && medicine.getSupplier().getId() != null) {
                Supplier supplier = supplierRepository.findById(medicine.getSupplier().getId()).orElse(null);
                if (supplier != null) {
                    medicine.setSupplier(supplier);
                } else {
                    throw new RuntimeException("Supplier with ID " + medicine.getSupplier().getId() + " not found.");
                }
            }
            return medicineRepository.save(medicine);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error creating medicine", e);
            throw new RuntimeException("Error creating medicine", e);
        }
    }

    public Medicine updateMedicine(Long id, Medicine medicineDetails) {
        try {
            Medicine medicine = medicineRepository.findById(id).orElse(null);
            if (medicine != null) {
                medicine.setName(medicineDetails.getName());
                medicine.setManufacturer(medicineDetails.getManufacturer());
                medicine.setPrice(medicineDetails.getPrice());
                if (medicineDetails.getSupplier() != null && medicineDetails.getSupplier().getId() != null) {
                    Supplier supplier = supplierRepository.findById(medicineDetails.getSupplier().getId()).orElse(null);
                    if (supplier != null) {
                        medicine.setSupplier(supplier);
                    } else {
                        throw new RuntimeException("Supplier with ID " + medicineDetails.getSupplier().getId() + " not found.");
                    }
                }
                return medicineRepository.save(medicine);
            }
            return null;
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error updating medicine", e);
            throw new RuntimeException("Error updating medicine", e);
        }
    }

    public void deleteMedicine(Long id) {
        try {
            medicineRepository.deleteById(id);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error deleting medicine", e);
            throw new RuntimeException("Error deleting medicine", e);
        }
    }
}
