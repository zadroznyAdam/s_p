package com.example.pharmacy.service;

import com.example.pharmacy.dao.PharmacistRepository;
import com.example.pharmacy.model.Pharmacist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PharmacistService {
    @Autowired
    private PharmacistRepository pharmacistRepository;

    public List<Pharmacist> getAllPharmacists() {
        return pharmacistRepository.findAll();
    }

    public Pharmacist getPharmacistById(Long id) {
        return pharmacistRepository.findById(id).orElse(null);
    }

    public Pharmacist createPharmacist(Pharmacist pharmacist) {
        return pharmacistRepository.save(pharmacist);
    }

    public Pharmacist updatePharmacist(Long id, Pharmacist pharmacistDetails) {
        Pharmacist pharmacist = pharmacistRepository.findById(id).orElse(null);
        if (pharmacist != null) {
            pharmacist.setName(pharmacistDetails.getName());
            pharmacist.setLicenseNumber(pharmacistDetails.getLicenseNumber());
            return pharmacistRepository.save(pharmacist);
        }
        return null;
    }

    public void deletePharmacist(Long id) {
        pharmacistRepository.deleteById(id);
    }
    public List<Pharmacist> getPharmacistsByName(String name) {
        return pharmacistRepository.findByNameContainingIgnoreCase(name);
    }

    public List<Pharmacist> getPharmacistsByLicenseNumber(String licenseNumber) {
        return pharmacistRepository.findByLicenseNumberContainingIgnoreCase(licenseNumber);
    }
}
