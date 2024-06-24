package com.example.pharmacy.service;

import com.example.pharmacy.dao.PrescriptionRepository;
import com.example.pharmacy.model.Prescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrescriptionService {
    @Autowired
    private PrescriptionRepository prescriptionRepository;

    public List<Prescription> getAllPrescriptions() {
        return prescriptionRepository.findAll();
    }

    public Prescription getPrescriptionById(Long id) {
        return prescriptionRepository.findById(id).orElse(null);
    }

    public Prescription createPrescription(Prescription prescription) {
        return prescriptionRepository.save(prescription);
    }

    public Prescription updatePrescription(Long id, Prescription prescriptionDetails) {
        Prescription prescription = prescriptionRepository.findById(id).orElse(null);
        if (prescription != null) {
            prescription.setDescription(prescriptionDetails.getDescription());
            prescription.setCustomer(prescriptionDetails.getCustomer());
            prescription.setMedicines(prescriptionDetails.getMedicines());
            return prescriptionRepository.save(prescription);
        }
        return null;
    }

    public void deletePrescription(Long id) {
        prescriptionRepository.deleteById(id);
    }

    public List<Prescription> getPrescriptionsByCustomerId(Long customerId) {
        return prescriptionRepository.findByCustomerId(customerId);
    }

    public List<Prescription> getPrescriptionsByStatus(String status) {
        return prescriptionRepository.findByStatus(status);
    }

    public List<Prescription> getPrescriptionsByCustomerIdAndStatus(Long customerId, String status) {
        return prescriptionRepository.findByCustomerIdAndStatus(customerId, status);
    }
}
