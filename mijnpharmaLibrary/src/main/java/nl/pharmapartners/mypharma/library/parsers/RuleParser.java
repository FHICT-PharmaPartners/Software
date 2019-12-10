package nl.pharmapartners.mypharma.library.parsers;

import nl.pharmapartners.mypharma.library.algorithm.models.MFB;
import nl.pharmapartners.mypharma.library.model.ATCRule;
import nl.pharmapartners.mypharma.library.model.PRKRule;
import nl.pharmapartners.mypharma.library.model.PatientRule;
import nl.pharmapartners.mypharma.library.model.enums.Sex;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RuleParser {
    public ArrayList<PatientRule> patientRuleFromResultSet(ResultSet rs){
        ArrayList<PatientRule> rule = new ArrayList<PatientRule>();

        try{
            // Fetch each row from resultset
            while(rs.next()){
                int id = rs.getInt("id");
                int age = rs.getInt("age");
                int weight = rs.getInt("weight");
                int creatineClearance = rs.getInt("CreatineClearance");

                Sex sex = rs.getInt("sex") != 0 ? Sex.FEMALE : Sex.MALE;
                boolean postMenoPause = rs.getInt("postMenoPause") != 0;

                rule.add(new PatientRule(id, age, sex, postMenoPause, weight, creatineClearance));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return rule;
    }

    public List<PRKRule> PRKRuleFromResultSet(ResultSet rs){
        /**
         * Logic...
         */
        return new ArrayList<PRKRule>();
    }

    public List<ATCRule> ATCRuleFromResultSet(ResultSet rs){
        /**
         * Logic...
         */
        return new ArrayList<ATCRule>();
    }

    public MFB fromResultSet(ResultSet rs){
        MFB mfb = null;

        try{
            if(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String ruleVersion = rs.getString("ruleVersion");

                mfb = new MFB(id, name, ruleVersion);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return mfb;
    }
}
