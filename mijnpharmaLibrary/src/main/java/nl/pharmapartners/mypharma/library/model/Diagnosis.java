package nl.pharmapartners.mypharma.library.model;

import java.util.List;

public class Diagnosis {
    private boolean passed;
    private List<String> issues;
    private boolean seeDoctor;

    public boolean isPassed() {
        return passed;
    }

    public void setPassed(boolean passed) {
        this.passed = passed;
    }

    public List<String> getIssues() {
        return issues;
    }

    public void setIssues(List<String> issues) {
        this.issues = issues;
    }

    public boolean isSeeDoctor() {
        return seeDoctor;
    }

    public void setSeeDoctor(boolean seeDoctor) {
        this.seeDoctor = seeDoctor;
    }
}
