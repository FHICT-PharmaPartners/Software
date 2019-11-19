package nl.pharmapartners.mypharma.library.algorithm.execution;

import nl.pharmapartners.mypharma.library.algorithm.models.MFB;
import nl.pharmapartners.mypharma.library.algorithm.models.RuleSet;
import nl.pharmapartners.mypharma.library.model.*;

import java.util.ArrayList;
import java.util.List;

public class Algorithm {

    /**
     * Logic operators:
     * 0: '='
     * 1: '>'
     * 2: '<'
     * 3: '>='
     * 4: '<='
     */

    private RuleSet ruleSet;
    private Patient patient;
    private boolean passedAll;

    /**
     * Constructor
     *
     * @param ruleSet
     * @param patient
     */

    public Algorithm(RuleSet ruleSet, Patient patient) {
        this.ruleSet = ruleSet;
        this.patient = patient;
        passedAll = executeAlgorithm();
    }

    private boolean executeAlgorithm() {
        boolean atcPassed = checkATC(ruleSet.getATCRuleList(), patient.getMedicationList());
        boolean prkPassed = checkPatient(ruleSet.getPatientRuleList(), patient);
        boolean patientPassed = checkPRK(ruleSet.getPRKRuleList(), patient.getMedicationList());
        boolean dosagePassed = checkDosage(ruleSet.getDosageRule(), patient.getMedicationList());
        boolean durationPassed = checkDuration(ruleSet.getDurationRule(), patient.getMedicationList());

        if (atcPassed && prkPassed && patientPassed && dosagePassed && durationPassed)
            return true;
        else
            return false;
    }

    /**
     * Foreach patientrule,
     * prkrule,
     * dosagerule,
     * durationrule,
     * atcrule
     *
     * @param atcRules
     * @param medicationList
     */

    private boolean checkATC(List<ATCRule> atcRules, List<Medication> medicationList) {
        //check if list contains any objects
        if (atcRules.size() > 0) {
            for (ATCRule r : atcRules) {
                /**
                 * if method returns a false, break loop and return false
                 */
                return false;
            }
            //if all in the list passed
            return true;
        } else
            //if list is empty return true
            return true;
    }

    private boolean checkDuration(List<Medication> medicationRules, List<Medication> medicationList) {
        if (medicationRules.size() > 0) {
            //logic
            return true;
        } else
            return true;
    }

    private boolean checkDosage(List<Medication> medicationRules, List<Medication> medicationList) {
        if (medicationRules.size() > 0) {
            //logic
            return true;
        } else
            return true;
    }

    private boolean checkPatient(List<PatientRule> patientRules, Patient patient) {
        if (patientRules.size() > 0) {
            //logic
            return true;
        } else
            return true;
    }

    private boolean checkPRK(List<PRKRule> prkRules, List<Medication> medicationList) {
        if (prkRules.size() > 0) {
            //logic
            return true;
        } else
            return true;
    }
}
