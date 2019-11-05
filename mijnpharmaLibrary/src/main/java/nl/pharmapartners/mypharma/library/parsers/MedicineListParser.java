package nl.pharmapartners.mypharma.library.parsers;

import nl.pharmapartners.mypharma.library.model.Medicine;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MedicineListParser {

    public ArrayList<Medicine> fromResultSet(ResultSet rs) {
        ArrayList<Medicine> medicines = new ArrayList<>();
        try {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");

                Medicine medicine = new Medicine(id, name, description);
                medicines.add(medicine);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return medicines;
    }

}
