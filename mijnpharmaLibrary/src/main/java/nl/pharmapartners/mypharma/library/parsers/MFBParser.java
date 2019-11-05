package nl.pharmapartners.mypharma.library.parsers;

import nl.pharmapartners.mypharma.library.algorithm.models.MFB;
import nl.pharmapartners.mypharma.library.model.Admin;
import nl.pharmapartners.mypharma.library.model.Patient;
import nl.pharmapartners.mypharma.library.model.User;
import nl.pharmapartners.mypharma.library.model.enums.Sex;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MFBParser {
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
