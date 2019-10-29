package nl.pharmapartners.mypharma.library.parsers;

import nl.pharmapartners.mypharma.library.model.User;

import java.sql.ResultSet;
import java.util.ArrayList;

public class UserListParser {

    public ArrayList<User> fromResultSet(ResultSet rs) {
        ArrayList users = new ArrayList();
        User user = null;
        UserParser parser = new UserParser();

        do {
            user = parser.fromResultSet(rs);

            if (user != null) {
                users.add(user);
            }
        } while (user == null);

        return users;
    }

}
