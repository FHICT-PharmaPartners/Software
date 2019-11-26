package nl.pharmapartners.mypharma.library.algorithm.execution;

import nl.pharmapartners.mypharma.library.algorithm.models.RuleSet;
import nl.pharmapartners.mypharma.library.model.*;
import nl.pharmapartners.mypharma.library.model.enums.Sex;

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
        boolean dosagePassed = checkDosage(ruleSet.getDosageRule(), patient.getMedicationList());
        boolean durationPassed = checkDuration(ruleSet.getDurationRule(), patient.getMedicationList());
        boolean prkPassed = checkPatient(ruleSet.getPatientRuleList(), patient);
        boolean patientPassed = checkPRK(ruleSet.getPRKRuleList(), patient.getMedicationList());

        if (atcPassed && dosagePassed && durationPassed && prkPassed && patientPassed)
            return false; //none failed. Return fail = false.
        else
            return true; //one or more failed to pass. Return fail = true.
    }

    public boolean checkATC(List<ATCRule> atcRules, List<Medication> medicationList) {
        if (atcRules.size() > 0) //check if rule list contains any objects
            for (Medication m : medicationList) { //loop through all medication that is currently used
                for (ATCRule r : atcRules) { //loop through all rules for each medicine that is used
                    if (!checkEquals(r.getATCCheck(), m.getMedicine().getAtc())) //check if any atc match using checkEquals().
                        return false; //did not pass so return false.
                }
            }
        return true; //if checklist is empty or all have passed. Return true.
    }

    public boolean checkDosage(List<DosageRule> dosageRules, List<Medication> medicationList) {
        if (dosageRules.size() > 0)
            for (Medication m : medicationList) {
                for (DosageRule r : dosageRules) {
                    if (!switchCheck(r.getDosageCheck(), m.getDosage(), r.getOperator()))
                        return false; //did not pass so return false.
                }
            }
        return true; //if checklist is empty or all have passed. Return true.
    }

    public boolean checkDuration(List<DurationRule> durationRules, List<Medication> medicationList) {
        if (durationRules.size() > 0)
            for (Medication m : medicationList) {
                for (DurationRule r : durationRules) {
                    if (!switchCheck(r.getDurationCheck(), m.getDuration(), r.getOperator()))
                        return false; //did not pass so return false.
                }
            }
        return true; //if checklist is empty or all have passed. Return true.
    }

    public boolean checkPatient(List<PatientRule> patientRules, Patient patient) {
        if (patientRules.size() > 0)
            for (PatientRule r : patientRules) {
                int ageRule = r.getAge();
                Sex sex = r.getSex();
                int creatineRule = r.getCreatineClearance();
                double weightRule = r.getWeight();
                boolean menoPauseRule = r.isPostMenopause();
                int operator = r.getOperator();

                if (ageRule != -1) {
                    if (!switchCheck(ageRule, patient.getAge(), operator))
                        return false;
                }
                if (sex != null) {
                    if (!checkEquals(sex.toString(), patient.getSex().toString()))
                        return false;
                }
                if (creatineRule != -1) {
                    if (!switchCheck(creatineRule, patient.getCreatineClearance(), operator))
                        return false;
                }
                if (weightRule != -1) {
                    if (!switchCheck((int) weightRule, (int) patient.getWeight(), operator)) //cast weight to int
                        return false;
                }
                if (sex == Sex.FEMALE)
                    if (menoPauseRule) {
                        int postMeno = 0;
                        if (patient.getPostMenoPause())
                            postMeno = 1;
                        if (!switchCheck(1, postMeno, operator))
                            return false;
                    }
            }
        return true; //if checklist is empty or all have passed. Return true.
    }

    public boolean checkPRK(List<PRKRule> prkRules, List<Medication> medicationList) {
        if (prkRules.size() > 0)
            for (Medication m : medicationList) {
                for (PRKRule r : prkRules) {
                    if (!checkEquals(r.getPRKCheck(), m.getMedicine().getPrk())) //check if any atc match using checkEquals().
                        return false; //did not pass so return false.
                }
            }
        return true; //if checklist is empty or all have passed. Return true.
    }

    private boolean checkEquals(String check, String current) {
        if (check == current)
            return false;
        return true;
    }

    private boolean switchCheck(int check, int current, int operator) {
        switch (operator) {
            case 0:
                /**
                 * Int should contain a value and shouldn't be 0 (==). Something went wrong so return false by default.
                 */
                return false;
            case 1:
                if (current > check)
                    return false;
                break;
            case 2:
                if (current < check)
                    return false;
                break;
            case 3:
                if (current >= check)
                    return false;
                break;
            case 4:
                if (current <= check)
                    return false;
                break;
        }
        return true;
    }
}
