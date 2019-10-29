package nl.pharmapartners.mypharma.library.dal.database;

import nl.pharmapartners.mypharma.library.model.database.Parameter;
import nl.pharmapartners.mypharma.library.model.database.SQLQuery;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class MySQLContext {

    public int executeUpdate(SQLQuery query) {
        PreparedStatement stmt = createStatement(query);
        int linesChanged = 0;

        try {
            linesChanged = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return linesChanged;
    }

    public boolean execute(SQLQuery query) {
        PreparedStatement stmt = createStatement(query);
        boolean success = false;

        try {
            success = stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return success;
    }

    public ResultSet executeQuery(SQLQuery query) {
        PreparedStatement stmt = createStatement(query);
        ResultSet rs = null;

        try {
            rs = stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rs;
    }

    public int executeGetId(SQLQuery query) {
        PreparedStatement stmt = createStatement(query);
        int id = 0;

        try {
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();

            if (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return id;
    }

    private Connection getConnection() {
        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Properties props = getProperties();

            String url = props.getProperty("url");
            String username = props.getProperty("username");
            String password = props.getProperty("password");

            con = DriverManager.getConnection(url, username, password);
        } catch (SQLException | ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

        return con;
    }

    private Properties getProperties() throws IOException {
        String filename = "/db.properties";
        Properties props = new Properties();

//        FileInputStream stream = new FileInputStream(filename);
        InputStream stream = getClass().getResourceAsStream(filename);
        props.load(stream);

        return props;
    }

    private void closeConnection(Connection con) {
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private PreparedStatement createStatement(SQLQuery query) {
        PreparedStatement stmt = null;

        try {
            Connection con = getConnection();
            stmt = con.prepareStatement(query.getQuery());
            applyParameters(stmt, query.getParameters());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return stmt;
    }

    private void applyParameters(PreparedStatement stmt, ArrayList<Parameter> params) throws SQLException {
        for (Parameter param : params) {
            int index = param.getIndex();
            Object value = param.getValue();

            if (value instanceof String) {
                stmt.setString(index, (String) value);
            } else if (value instanceof Integer) {
                stmt.setInt(index, (int) value);
            } else if (value instanceof Double) {
                stmt.setDouble(index, (double) value);
            } else if (value instanceof Float) {
                stmt.setFloat(index, (float) value);
            } else if (value instanceof Timestamp) {
                stmt.setTimestamp(index, (Timestamp) value);
            } else {
                stmt.setObject(index, value);
            }
        }
    }
}
