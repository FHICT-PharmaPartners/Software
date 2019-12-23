package nl.pharmapartners.mypharma.library.algorithm.execution;

import nl.pharmapartners.mypharma.library.algorithm.models.RuleSet;
import nl.pharmapartners.mypharma.library.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Executor {
    private Algorithm algorithm;
    private Patient patient;
    private List<RuleSet> ruleSets;
    ExecutorService pool;

    public Executor(List<RuleSet> ruleSets, Patient patient) {
        this.ruleSets = ruleSets;
        this.patient = patient;
        algorithm = new Algorithm();
        //set threadpool
        pool = Executors.newFixedThreadPool(patient.getMedicineList().size());
    }

    public Diagnosis checkAll(){
        List<Diagnosis> diagnoses = new ArrayList<>();
        Diagnosis finalDiagnosis = new Diagnosis();
        finalDiagnosis.setPassed(true);
        finalDiagnosis.setIssues(new ArrayList<>());
        List<AlgorithmThread> threads = new ArrayList<>();

        //run algorithm for each medicine
        for (PatientMedicine m : patient.getMedicineList()){
            //diagnoses.add(algorithm.run(getRuleSet(m.getMedicine().getId()), patient));
            AlgorithmThread thread = new AlgorithmThread(getRuleSet(m.getMedicine().getId()), patient);
            pool.execute(thread);
            threads.add(thread);
        }

        //shut down pool after running algorithm
        pool.shutdown();

        //wait until tasks end
        try {
            pool.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
            // Restore interrupted state...
            Thread.currentThread().interrupt();
        }

        //merge diagnoses to one final diagnosis
        for (AlgorithmThread t : threads){
            if(!t.getDiagnosis().isPassed()){
                finalDiagnosis.setPassed(false);
            }
            finalDiagnosis.getIssues().addAll(t.getDiagnosis().getIssues());
        }

        return finalDiagnosis;
    }

    private RuleSet getRuleSet(String id){
        for (RuleSet r : ruleSets){
            if (r.getMedicineId().equals(id)){
                return r;
            }
        }
        return null;
    }
}
