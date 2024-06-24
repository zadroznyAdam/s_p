package com.example.pharmacy.webAPI;

import com.example.pharmacy.model.Medicine;
import com.example.pharmacy.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/medicines")
public class MedicineController {
    private static final Logger LOGGER = Logger.getLogger(MedicineController.class.getName());

    @Autowired
    private MedicineService medicineService;

    @GetMapping
    public List<Medicine> getAllMedicines(
        @RequestParam(required = false) String sortBy,
        @RequestParam(required = false) String sortDirection
    ) {
        try {
            LOGGER.info("Received request to fetch all medicines");
            return medicineService.getAllMedicines(sortBy, sortDirection);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error fetching medicines", e);
            throw new RuntimeException("Error fetching medicines", e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medicine> getMedicineById(@PathVariable Long id) {
        Medicine medicine = medicineService.getMedicineById(id);
        if (medicine == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(medicine);
    }

    @PostMapping
    public Medicine createMedicine(@RequestBody Medicine medicine) {
        return medicineService.createMedicine(medicine);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Medicine> updateMedicine(@PathVariable Long id, @RequestBody Medicine medicineDetails) {
        Medicine updatedMedicine = medicineService.updateMedicine(id, medicineDetails);
        if (updatedMedicine == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedMedicine);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedicine(@PathVariable Long id) {
        medicineService.deleteMedicine(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/filter")
    public List<Medicine> getMedicinesByFilter(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String manufacturer,
            @RequestParam(required = false) Long supplierId) {
        return medicineService.getMedicinesByFilter(name, manufacturer, supplierId);
    }
}
