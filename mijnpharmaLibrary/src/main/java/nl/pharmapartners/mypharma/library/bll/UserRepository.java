package nl.pharmapartners.mypharma.library.bll;

import nl.pharmapartners.mypharma.library.dal.database.MySQLUserContext;
import nl.pharmapartners.mypharma.library.model.User;

import java.util.ArrayList;

public class UserRepository {

    private ArrayList<User> users;
    private MySQLUserContext context;

    public UserRepository() {
        context = new MySQLUserContext();
    }

    public ArrayList<User> getUsers() {
        if (users == null) {
            users = context.getUsers();
        }

        // Return a copy of the array
        return new ArrayList<>(users);
    }

    public User getUserById(int id) {
        return context.getUserById(id);
    }

    private MySQLUserContext getContext() {
        if (context == null) {
            context = new MySQLUserContext();
        }

        return context;
    }

}
