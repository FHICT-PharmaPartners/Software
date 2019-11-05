package nl.pharmapartners.mypharma.library.dal.database;

import nl.pharmapartners.mypharma.library.model.Medicine;
import nl.pharmapartners.mypharma.library.model.database.SQLQuery;
import nl.pharmapartners.mypharma.library.parsers.MedicineListParser;
import nl.pharmapartners.mypharma.library.parsers.MedicineParser;

import java.sql.ResultSet;
import java.util.ArrayList;

public class MySQLMedicineContext {

    private MySQLContext mysql;

    public MySQLMedicineContext() {
        mysql = new MySQLContext();
    }

    public ArrayList<Medicine> getAllMedicine() {
        SQLQuery query = new SQLQuery("SELECT * FROM medicine");
        ResultSet rs = mysql.executeQuery(query);
        ArrayList<Medicine> medicine = new MedicineListParser().fromResultSet(rs);

        return medicine;
    }

    public Medicine getMedicineById(int id){
        SQLQuery query = new SQLQuery("SELECT * FROM medicine WHERE id = ?");
        query.addParameter(1, id);
        ResultSet rs = mysql.executeQuery(query);
        Medicine medicine = new MedicineParser().fromResulteSet(rs);

        return medicine;
    }
}
