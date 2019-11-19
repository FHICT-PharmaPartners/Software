package nl.pharmapartners.mypharma.library.model;

public abstract class User {
    private int id;
    private String firstName;
    private String insertion;
    private String lastName;
    private String emailAddress;
    private String password;

    public User(int id, String firstName, String insertion, String lastName, String emailAddress, String password) {
        this.id = id;
        this.firstName = firstName;
        this.insertion = insertion;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.password = password;
    }

    public User() {
        //empty constructor
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getInsertion() {
        return insertion;
    }

    public void setInsertion(String insertion) {
        this.insertion = insertion;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
