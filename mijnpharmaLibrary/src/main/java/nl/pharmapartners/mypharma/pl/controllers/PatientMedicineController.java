package nl.pharmapartners.mypharma.pl.controllers;

import nl.pharmapartners.mypharma.library.dal.repository.PatientMedicineRepository;
import nl.pharmapartners.mypharma.library.model.PatientMedicine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/patientmedicine")
public class PatientMedicineController {

    private PatientMedicineRepository patientMedicineRepository;

    @Autowired
    private void setPatientMedicineRepository(PatientMedicineRepository patientMedicineRepository){
        this.patientMedicineRepository = patientMedicineRepository;
    }

    @GetMapping()
    public List<PatientMedicine> getAllPatientMedicine(){
        return patientMedicineRepository.findAll();
    }
}