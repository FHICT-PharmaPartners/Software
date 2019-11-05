package nl.pharmapartners.mypharma.library.dal.database;

import nl.pharmapartners.mypharma.library.model.Medication;
import nl.pharmapartners.mypharma.library.model.Medicine;
import nl.pharmapartners.mypharma.library.model.User;
import nl.pharmapartners.mypharma.library.model.database.SQLQuery;
import nl.pharmapartners.mypharma.library.parsers.MedicineListParser;

import java.sql.ResultSet;
import java.util.ArrayList;

public class MySQLMedication {
    private MySQLContext mysql;

    public MySQLMedication() {
        mysql = new MySQLContext();
    }

    public void addMedication(User user, Medication medication) {
        SQLQuery query = new SQLQuery("INSERT INTO medication (userId, medicineId, dosage, usageDuration) VALUES (?,?,?,?)");
        query.addParameter(1, user.getId());
        query.addParameter(2, medication.getMedicine().getId());
        query.addParameter(3, medication.getDosage());
        query.addParameter(4, medication.getDuration());
        ResultSet rs = mysql.executeQuery(query);
    }
}
