package nl.pharmapartners.mypharma.library.parsers;

import nl.pharmapartners.mypharma.library.model.enums.Sex;
import nl.pharmapartners.mypharma.library.model.Admin;
import nl.pharmapartners.mypharma.library.model.Patient;
import nl.pharmapartners.mypharma.library.model.User;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserListParser {

    public ArrayList<User> fromResultSet(ResultSet rs) {
        ArrayList users = new ArrayList();

        try {
            while (rs.next()) {
                int id = rs.getInt("id");
                String firstName = rs.getString("firstName");
                String insertion = rs.getString("insertion");
                String lastName = rs.getString("lastName");
                String emailAddress = rs.getString("emailAddress");
                String password = rs.getString("password");
                boolean admin = rs.getBoolean("admin");
                User user = null;

                if (admin) {
                    user = new Admin(id, firstName, insertion, lastName, emailAddress, password);
                } else {
                    Date dateOfBirth = rs.getDate("dateOfBirth");
                    double height = rs.getDouble("height");
                    double weight = rs.getDouble("weight");
                    Sex sex = Sex.valueOf(rs.getInt("sex"));
                    int creatineClearance = rs.getInt("creatineClearance");

                    user = new Patient(id, firstName, insertion, lastName, emailAddress, password, dateOfBirth, height, weight, sex, creatineClearance);
                }

                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

}
