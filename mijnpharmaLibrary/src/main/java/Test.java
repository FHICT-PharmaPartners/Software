import DAL.Models.Gender;
import DAL.Models.Patient;

import java.util.Date;

public class Test {

    public static void main(String[] args) {
        Date date = new Date();
        Patient patient = new Patient("Bert", "De", "Vink", date, 180, 85, Gender.MALE );
        System.out.println(patient);
    }
}
