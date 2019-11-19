package nl.pharmapartners.mypharma.library.algorithm.execution;

import nl.pharmapartners.mypharma.library.algorithm.models.MFB;
import nl.pharmapartners.mypharma.library.algorithm.models.RuleSet;
import nl.pharmapartners.mypharma.library.model.*;

import java.time.Duration;
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

    /**
     * Constructor
     *
     * @param ruleSet
     * @param patient
     */

    public Algorithm(RuleSet ruleSet, Patient patient) {
        this.ruleSet = ruleSet;
        this.patient = patient;
    }

    public boolean executeAlgorithm() {
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

    public boolean checkATC(List<ATCRule> atcRules, List<Medication> medicationList) {
        //check if rule list contains any objects
        if (atcRules.size() > 0) {
            //loop through all medication that is currently used
            for (Medication m : medicationList) {
                //loop through all rules for each medicine that is used
                for (ATCRule r : atcRules) {
                    /**
                     * if method returns a false, break loop and return false
                     *
                     * No operator needed as this check only checks if an ATC is present (so '==')
                     */
                    if (r.getATCCheck() == m.getMedicine().getAtc())
                        //if medicine contains the same ATC as the check, medicine is incompatible so return false.
                        return false;
                }
            }
            //if all in the list passed
            return true;
        } else {
            //if list is empty return true
            return true;
        }
    }

    public boolean checkDuration(List<DurationRule> durationRules, List<Medication> medicationList) {
        if (durationRules.size() > 0) {
            for (Medication m : medicationList) {
                for (DurationRule r : durationRules) {
                    /**
                     * if method returns a false, break loop and return false
                     */
                    return false;
                }
            }
            return true;
        } else
            return true;
    }

    public boolean checkDosage(List<DosageRule> dosageRules, List<Medication> medicationList) {
        if (dosageRules.size() > 0) {
            for (Medication m : medicationList) {
                for (DosageRule r : dosageRules) {
                    /**
                     * if method returns a false, break loop and return false
                     */
                    return false;
                }
            }
            return true;
        } else
            return true;
    }

    public boolean checkPatient(List<PatientRule> patientRules, Patient patient) {
        if (patientRules.size() > 0) {
            for (PatientRule r : patientRules) {
                if (r.getAge() != -1) {
                    //logic
                }
                if (r.getSex() != null) {
                    //logic
                }
                if (r.getCreatineClearance() != -1) {
                    //logic
                }
                if (r.getWeight() != -1) {
                    //logic
                }
                if (r.getPostMenopause()) {
                    //if this bool is true, then the algorithm should check if the patient has gone trough menopause.
                }
            }
            return true;
        } else
            return true;
    }

    public boolean checkPRK(List<PRKRule> prkRules, List<Medication> medicationList) {
        if (prkRules.size() > 0) {
            for (Medication m : medicationList) {
                for (PRKRule r : prkRules) {
                    /**
                     * if method returns a false, break loop and return false
                     */
                    return false;
                }
            }
            return true;
        } else
            return true;
    }
}
