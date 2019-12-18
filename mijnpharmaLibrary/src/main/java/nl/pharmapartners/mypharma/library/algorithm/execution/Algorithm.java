package nl.pharmapartners.mypharma.library.algorithm.execution;

import nl.pharmapartners.mypharma.library.algorithm.models.RuleSet;
import nl.pharmapartners.mypharma.library.model.*;
import nl.pharmapartners.mypharma.library.model.enums.Sex;

import java.util.ArrayList;
import java.util.List;

public class Algorithm {
    private Diagnosis diagnosis = new Diagnosis();
    private RuleSet ruleSet;

    /**
     * Logic operators:
     * 0: '='
     * 1: '>'
     * 2: '<'
     * 3: '>='
     * 4: '<='
     */

    public Diagnosis run(RuleSet r, Patient patient) {
        this.ruleSet = r;
        diagnosis.setIssues(new ArrayList<>());

        boolean atcPassed = checkATC(ruleSet.getATCRuleList(), patient.getMedicineList());
        boolean dosagePassed = checkDosage(ruleSet.getDosageRuleList(), patient.getMedicineList());
        boolean durationPassed = checkDuration(ruleSet.getDurationRuleList(), patient.getMedicineList());
        boolean patientPassed = checkPatient(ruleSet.getPatientRuleList(), patient);
        boolean prkPassed = checkPRK(ruleSet.getPRKRuleList(), patient.getMedicineList());

        if (atcPassed && dosagePassed && durationPassed && prkPassed && patientPassed) {
            diagnosis.setPassed(true); //none failed. Passed = true;
        } else {
            diagnosis.setPassed(false); //one or more failed to pass. Passed = false;
        }

        return diagnosis;
    }

    public boolean checkATC(List<ATCRule> atcRules, List<PatientMedicine> medicationList) {
        boolean passed = true;

        if (atcRules.size() > 0) //check if rule list contains any objects
            for (PatientMedicine m : medicationList) { //loop through all medication that is currently used
                for (ATCRule r : atcRules) { //loop through all rules for each medicine that is used
                    if (!checkEquals(r.getATCCheck(), m.getMedicine().getMedicineAtc())) { //check if any atc match using checkEquals().
                        try {
                            diagnosis.getIssues().add(m.getMedicine().getName() + " heeft een conflict veroorzaakt met " + ruleSet.getName());
                        } catch (Exception e) {
                            //do nothing
                        }
                        passed = false; //did not pass so return false.
                    }
                }
            }
        return passed; //if checklist is empty or all have passed. Return true.
    }

    public boolean checkDosage(List<DosageRule> dosageRules, List<PatientMedicine> medicationList) {
        boolean passed = true;

        if (dosageRules.size() > 0) {
            for (PatientMedicine m : medicationList) {
                for (DosageRule r : dosageRules) {
                    if (!switchCheck(r.getDosage(), m.getDosage(), r.getOperator())) {
                        try {
                            diagnosis.getIssues().add(m.getMedicine().getName() + " heeft een conflict veroorzaakt met " + ruleSet.getName());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        passed = false; //did not pass so return false.
                    }
                }
            }
        }
        return passed; //if checklist is empty or all have passed. Return true.
    }

    public boolean checkDuration(List<DurationRule> durationRules, List<PatientMedicine> medicationList) {
        boolean passed = true;

        if (durationRules.size() > 0)
            for (PatientMedicine m : medicationList) {
                for (DurationRule r : durationRules) {
                    if (!switchCheck(r.getDurationCheck(), m.getUsageDuration(), r.getOperator())) {
                        try {
                            diagnosis.getIssues().add(m.getMedicine().getName() + " heeft een conflict veroorzaakt met " + ruleSet.getName());
                        } catch (Exception e) {
                            //do nothing
                        }
                        passed = false; //did not pass so return false.
                    }
                }
            }
        return passed; //if checklist is empty or all have passed. Return true.
    }

    public boolean checkPatient(List<PatientRule> patientRules, Patient patient) {
        boolean passed = true;

        if (patientRules.size() > 0)
            for (PatientRule r : patientRules) {
                int ageRule = r.getAge();
                Sex sex = r.getSex();
                int creatineRule = r.getCreatineClearance();
                double weightRule = r.getWeight();
                boolean menoPauseCheck = r.isPostMenopauseCheck();
                int operator = r.getOperator();

                if (ageRule != 0) {
                    if (!switchCheck(ageRule, patient.getAge(), operator)) {
                        try {
                            diagnosis.getIssues().add("Uw leeftijd heeft een conflict veroorzaakt met " + ruleSet.getName());
                        } catch (Exception e) {
                            //do nothing
                        }
                        passed = false;
                    }
                }
                if (sex != null) {
                    if (!sex.toString().equals(patient.getSex().toString())) {
                        try {
                            diagnosis.getIssues().add("Uw geslacht heeft een conflict veroorzaakt met " + ruleSet.getName());
                        } catch (Exception e) {
                            //do nothing
                        }
                        passed = false;
                    }
                }
                if (creatineRule != 0) {
                    if (!switchCheck(creatineRule, patient.getCreatineClearance(), operator)) {
                        try {
                            diagnosis.getIssues().add("Uw creatinegehalte heeft een conflict veroorzaakt met " + ruleSet.getName());
                        } catch (Exception e) {
                            //do nothing
                        }
                        passed = false;
                    }
                }
                if (weightRule != 0) {
                    if (!switchCheck((int) weightRule, (int) patient.getWeight(), operator)) {//cast weight to int
                        try {
                            diagnosis.getIssues().add("Uw gewicht heeft een conflict veroorzaakt met " + ruleSet.getName());
                        } catch (Exception e) {
                            //do nothing
                        }
                        passed = false;
                    }
                }
                if (patient.getSex() == Sex.FEMALE)
                    if (menoPauseCheck) {
                        if (r.isPostMenoPause() != patient.getPostMenoPause()) {
                            try {
                                diagnosis.getIssues().add("De overgang heeft een conflict veroorzaakt met " + ruleSet.getName());
                            } catch (Exception e) {
                                //do nothing
                            }
                            passed = false;
                        }
                    }
            }
        return passed; //if checklist is empty or all have passed. Return true.
    }

    public boolean checkPRK(List<PRKRule> prkRules, List<PatientMedicine> medicationList) {
        boolean passed = true;

        if (prkRules.size() > 0)
            for (PatientMedicine m : medicationList) {
                for (PRKRule r : prkRules) {
                    if (!checkEquals(r.getPRKCheck(), m.getMedicine().getMedicinePrk())) {
                        try {
                            diagnosis.getIssues().add(m.getMedicine().getName() + " heeft een conflict veroorzaakt met " + ruleSet.getName());
                        } catch (Exception e) {
                            //do nothing
                        }
                        passed = false; //did not pass so return false.
                    }
                }
            }
        return passed; //if checklist is empty or all have passed. Return true.
    }

    private boolean checkEquals(String check, String current) {
        return !check.equals(current);
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
