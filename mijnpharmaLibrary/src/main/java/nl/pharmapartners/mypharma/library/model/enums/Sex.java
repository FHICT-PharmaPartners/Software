package nl.pharmapartners.mypharma.library.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum Sex {
    MALE(0),
    FEMALE(1);

    private int code;
    private static Map map = new HashMap<>();

    Sex(int code) {
        this.code = code;
    }

    public static Sex valueOf(int number) {
        Sex sex;

        switch (number){
            case 0:
                sex = MALE;
                break;
            case 1:
                sex = FEMALE;
                break;
            default:
                sex = null;
        }

        return sex;
    }
}
