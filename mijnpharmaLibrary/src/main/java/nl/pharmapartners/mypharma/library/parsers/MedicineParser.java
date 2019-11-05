package nl.pharmapartners.mypharma.library.parsers;

import nl.pharmapartners.mypharma.library.model.Medicine;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MedicineParser {
    public Medicine fromResultSet(ResultSet rs) {
        Medicine medicine = null;

        try {
            if (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");

                medicine = new Medicine(id, name, description);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return medicine;
    }
}

