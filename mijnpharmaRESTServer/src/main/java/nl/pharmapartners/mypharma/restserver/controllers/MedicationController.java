package nl.pharmapartners.mypharma.restserver.controllers;

import com.google.gson.Gson;
import nl.pharmapartners.mypharma.library.bll.MedicineRepository;
import nl.pharmapartners.mypharma.library.model.Medication;
import nl.pharmapartners.mypharma.library.model.Medicine;
import nl.pharmapartners.mypharma.library.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequestMapping("/medication")
@RestController
public class MedicationController {

    MedicationController medicationRepo = new MedicationController();

    @PostMapping()
    public void addMedication() {

    }
}
