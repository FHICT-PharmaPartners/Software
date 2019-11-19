package nl.pharmapartners.mypharma.library.dal.database;

import javafx.css.Rule;
import nl.pharmapartners.mypharma.library.algorithm.models.MFB;
import nl.pharmapartners.mypharma.library.algorithm.models.RuleSet;
import nl.pharmapartners.mypharma.library.dal.database.MySQLContext;
import nl.pharmapartners.mypharma.library.model.*;
import nl.pharmapartners.mypharma.library.model.database.SQLQuery;
import nl.pharmapartners.mypharma.library.model.interfaces.IRuleContext;
import nl.pharmapartners.mypharma.library.parsers.MFBParser;
import nl.pharmapartners.mypharma.library.parsers.RuleParser;
import nl.pharmapartners.mypharma.library.parsers.UserListParser;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MySQLRuleContext implements IRuleContext {
    private MySQLContext mysql;

    public MySQLRuleContext() {
        this.mysql = new MySQLContext();
    }

    public MFB getMFB(int id) {
        SQLQuery query = new SQLQuery("SELECT * FROM `mfb` WHERE id= ?");
        query.addParameter(1, id);
        ResultSet rs = mysql.executeQuery(query);
        MFB mfb = new MFBParser().fromResultSet(rs);

        return mfb;
    }

    /**
     * Main method to test whether query returns correct result, should be removed once finished.
     * @param args
     */
//    public static void main(String args[]){
//        MySQLRuleContext c = new MySQLRuleContext();
//        List<PatientRule> r = c.getPatientRule(1);
//        System.out.println(r.size());
//    }

    public RuleSet getRuleSet(int id){
        return new RuleSet(getPatientRule(id), getPRKRule(id), getATCRule(id));
    }

    private List<PatientRule> getPatientRule(int id) {
        SQLQuery query = new SQLQuery("SELECT * FROM patient_rule INNER JOIN mfb_patientrule ON patient_rule.id = mfb_patientrule.PatientRuleId WHERE MFBId = ?");
        query.addParameter(1, id);
        ResultSet rs = mysql.executeQuery(query);
        List<PatientRule> rule = new RuleParser().patientRuleFromResultSet(rs);

        return rule;
    }

    private List<PRKRule> getPRKRule(int id) {
        SQLQuery query = new SQLQuery("SELECT * FROM prk_rule INNER JOIN mfb_prkrule ON prk_rule.id = mfb_prkrule.PRKRuleId WHERE MFBId = ?");
        query.addParameter(1, id);
        ResultSet rs = mysql.executeQuery(query);
        /**
         * parse to list of rules here
         */

        return new ArrayList<PRKRule>();
    }

    private List<ATCRule> getATCRule(int id) {
        SQLQuery query = new SQLQuery("SELECT * FROM atc_rule INNER JOIN mfb_atcrule ON atc_rule.id = mfb_atcrule.ATCRuleId WHERE MFBId = ?");
        query.addParameter(1, id);
        ResultSet rs = mysql.executeQuery(query);
        /**
         * parse to list of rules here
         */
        //ATCRule atc = new ATCRuleParser().fromResultSet(rs);

        return new ArrayList<ATCRule>();
    }
}
