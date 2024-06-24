package com.example.pharmacy.webAPI;

import com.example.pharmacy.model.Pharmacist;
import com.example.pharmacy.service.PharmacistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pharmacists")
public class PharmacistController {
    @Autowired
    private PharmacistService pharmacistService;

    @GetMapping
    public List<Pharmacist> getAllPharmacists() {
        return pharmacistService.getAllPharmacists();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pharmacist> getPharmacistById(@PathVariable Long id) {
        Pharmacist pharmacist = pharmacistService.getPharmacistById(id);
        if (pharmacist == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(pharmacist);
    }

    @PostMapping
    public Pharmacist createPharmacist(@RequestBody Pharmacist pharmacist) {
        return pharmacistService.createPharmacist(pharmacist);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pharmacist> updatePharmacist(@PathVariable Long id, @RequestBody Pharmacist pharmacistDetails) {
        Pharmacist updatedPharmacist = pharmacistService.updatePharmacist(id, pharmacistDetails);
        if (updatedPharmacist == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedPharmacist);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePharmacist(@PathVariable Long id) {
        pharmacistService.deletePharmacist(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/by-name")
    public List<Pharmacist> getPharmacistsByName(@RequestParam String name) {
        return pharmacistService.getPharmacistsByName(name);
    }

    @GetMapping("/by-license-number")
    public List<Pharmacist> getPharmacistsByLicenseNumber(@RequestParam String licenseNumber) {
        return pharmacistService.getPharmacistsByLicenseNumber(licenseNumber);
    }
}
