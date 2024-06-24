package com.example.pharmacy.webAPI;

import com.example.pharmacy.model.Prescription;
import com.example.pharmacy.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prescriptions")
public class PrescriptionController {
    @Autowired
    private PrescriptionService prescriptionService;

    @GetMapping
    public List<Prescription> getAllPrescriptions() {
        return prescriptionService.getAllPrescriptions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prescription> getPrescriptionById(@PathVariable Long id) {
        Prescription prescription = prescriptionService.getPrescriptionById(id);
        if (prescription == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(prescription);
    }

    @PostMapping
    public Prescription createPrescription(@RequestBody Prescription prescription) {
        return prescriptionService.createPrescription(prescription);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Prescription> updatePrescription(@PathVariable Long id, @RequestBody Prescription prescriptionDetails) {
        Prescription updatedPrescription = prescriptionService.updatePrescription(id, prescriptionDetails);
        if (updatedPrescription == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedPrescription);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrescription(@PathVariable Long id) {
        prescriptionService.deletePrescription(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/by-customer")
    public List<Prescription> getPrescriptionsByCustomerId(@RequestParam Long customerId) {
        return prescriptionService.getPrescriptionsByCustomerId(customerId);
    }

    @GetMapping("/by-status")
    public List<Prescription> getPrescriptionsByStatus(@RequestParam String status) {
        return prescriptionService.getPrescriptionsByStatus(status);
    }

    @GetMapping("/by-customer-and-status")
    public List<Prescription> getPrescriptionsByCustomerIdAndStatus(@RequestParam Long customerId, @RequestParam String status) {
        return prescriptionService.getPrescriptionsByCustomerIdAndStatus(customerId, status);
    }
}
