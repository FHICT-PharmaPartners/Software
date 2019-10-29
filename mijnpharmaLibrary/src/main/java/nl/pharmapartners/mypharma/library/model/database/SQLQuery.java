package nl.pharmapartners.mypharma.library.model.database;

import java.util.ArrayList;

public class SQLQuery {
    private final String query;
    private ArrayList<Parameter> parameters;

    public SQLQuery(String query)
    {
        this.query = query;
        parameters = new ArrayList<>();
    }

    public void addParameter(int index, Object value)
    {
        parameters.add(new Parameter(index, value));
    }

    public ArrayList<Parameter> getParameters() {
        return parameters;
    }

    public String getQuery() {
        return query;
    }
}
