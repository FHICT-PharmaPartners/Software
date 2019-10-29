package nl.pharmapartners.mypharma.library.dal.database;

import nl.pharmapartners.mypharma.library.model.User;
import nl.pharmapartners.mypharma.library.model.database.SQLQuery;
import nl.pharmapartners.mypharma.library.parsers.UserListParser;
import nl.pharmapartners.mypharma.library.parsers.UserParser;

import java.sql.ResultSet;
import java.util.ArrayList;

public class MySQLUserContext {

    private MySQLContext mysql;

    public MySQLUserContext() {
        mysql = new MySQLContext();
    }

    public ArrayList<User> getUsers() {
        SQLQuery query = new SQLQuery("SELECT * FROM user u LEFT JOIN medicalinfo m ON u.id = m.userId");
        ResultSet rs = mysql.executeQuery(query);
        ArrayList<User> users = new UserListParser().fromResultSet(rs);

        return users;
    }

    public User getUserById(int id) {
        SQLQuery query = new SQLQuery("SELECT * FROM user u LEFT JOIN medicalinfo m ON u.id = m.userId WHERE u.id = ?");
        query.addParameter(1, id);
        ResultSet rs = mysql.executeQuery(query);
        User user = new UserParser().fromResultSet(rs);

        return user;
    }
}
