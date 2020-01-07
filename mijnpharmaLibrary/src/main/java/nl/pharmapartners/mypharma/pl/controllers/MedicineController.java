package nl.pharmapartners.mypharma.pl.controllers;

import nl.pharmapartners.mypharma.library.dal.repository.MedicineRepository;
import nl.pharmapartners.mypharma.library.model.Medicine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicine")
public class MedicineController {

    private MedicineRepository medicineRepository;

    @Autowired
    private void setMedicineRepository(MedicineRepository medicineRepository){
        this.medicineRepository = medicineRepository;
    }

    @GetMapping()
    public List<Medicine> getAllMedicine() {
        return medicineRepository.findAll();
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addMedicine(@RequestBody Medicine medicine){
        medicineRepository.save(medicine);
    }
}
