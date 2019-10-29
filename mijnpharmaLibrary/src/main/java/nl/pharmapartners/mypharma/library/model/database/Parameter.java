package nl.pharmapartners.mypharma.library.model.database;

public class Parameter {

    private int index;
    private Object value;

    public Parameter(int index, Object value) {
        this.index = index;
        this.value = value;
    }

    public int getIndex() {
        return index;
    }

    public Object getValue() {
        return value;
    }
}
