package nl.pharmapartners.mypharma.library.dal.database;

import nl.pharmapartners.mypharma.library.algorithm.models.MFB;
import nl.pharmapartners.mypharma.library.model.User;
import nl.pharmapartners.mypharma.library.model.database.SQLQuery;
import nl.pharmapartners.mypharma.library.parsers.MFBParser;
import nl.pharmapartners.mypharma.library.parsers.UserListParser;

import java.sql.ResultSet;
import java.util.ArrayList;

public class MySQLRuleContext {
    private MySQLContext mysql;

    public MySQLRuleContext(MySQLContext mysql) {
        this.mysql = mysql;
    }

    public MFB getMFB(int id) {
        SQLQuery query = new SQLQuery("SELECT * FROM `mfb` WHERE id= ?");
        query.addParameter(1, id);
        ResultSet rs = mysql.executeQuery(query);
        MFB mfb = new MFBParser().fromResultSet(rs);

        return mfb;
    }
}
