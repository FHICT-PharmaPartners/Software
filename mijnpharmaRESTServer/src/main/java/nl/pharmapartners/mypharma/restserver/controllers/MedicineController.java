package nl.pharmapartners.mypharma.restserver.controllers;

import nl.pharmapartners.mypharma.library.bll.MedicineRepository;
import nl.pharmapartners.mypharma.library.model.Medicine;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RequestMapping("/medicine")
@RestController
public class MedicineController {

    MedicineRepository medicineRepo = new MedicineRepository();

    @GetMapping()
    public ArrayList<Medicine> getAllMedicine() {
        return medicineRepo.getAllMedicine();
    }
}
