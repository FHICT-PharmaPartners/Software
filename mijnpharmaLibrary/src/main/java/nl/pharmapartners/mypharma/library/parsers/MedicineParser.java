package nl.pharmapartners.mypharma.library.parsers;

import nl.pharmapartners.mypharma.library.model.Medicine;

import java.sql.ResultSet;

public class MedicineParser {

    public Medicine fromResulteSet(ResultSet rs){
        Medicine medicine = null;

        try{
            if (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");

            }
        }
    }
}
