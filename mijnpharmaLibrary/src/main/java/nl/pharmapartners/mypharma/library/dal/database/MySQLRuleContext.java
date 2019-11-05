package nl.pharmapartners.mypharma.library.dal.database;

import nl.pharmapartners.mypharma.library.algorithm.models.MFB;
import nl.pharmapartners.mypharma.library.algorithm.models.RuleSet;
import nl.pharmapartners.mypharma.library.dal.database.MySQLContext;
import nl.pharmapartners.mypharma.library.model.User;
import nl.pharmapartners.mypharma.library.model.database.SQLQuery;
import nl.pharmapartners.mypharma.library.model.interfaces.IRuleContext;
import nl.pharmapartners.mypharma.library.parsers.MFBParser;
import nl.pharmapartners.mypharma.library.parsers.UserListParser;

import java.sql.ResultSet;
import java.util.ArrayList;

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

//    public RuleSet getRuleSet(int id){
//        return new RuleSet();
//    }
}
