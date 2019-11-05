package nl.pharmapartners.mypharma.restserver.controllers;

import nl.pharmapartners.mypharma.library.bll.MedicineRepository;
import nl.pharmapartners.mypharma.library.model.Medicine;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequestMapping("/medicine")
@RestController
public class MedicineController {

    MedicineRepository medicineRepo = new MedicineRepository();

    @GetMapping()
    public ArrayList<Medicine> getAllMedicine() {
        return medicineRepo.getAllMedicine();
    }

    @GetMapping(value = "/getByName/{name}")
    public ArrayList<Medicine> getMedicineByName(@PathVariable("name") String name){
        return medicineRepo.getMedicineByName(name);
    }

    @GetMapping(value = "/getById/{id}")
    public Medicine getMedicineById(@PathVariable("id") int id){
        return medicineRepo.getMedicineById(id);
    }
}
