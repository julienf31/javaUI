package gui.domain;

public abstract class Employee {

    private static String NAME_PATTERN = "%s %s %s";
    private String firstname;
    private String lastname;
    private int age;
    private String entryYear;
    private double Unit;


    public Employee(String firstname, String lastname, int age, String entryYear) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.entryYear = entryYear;
    }

    public abstract double calculerSalaire();
    public abstract String getPosition();

    public String getName() {
        return String.format(NAME_PATTERN, getPosition(), firstname, lastname);
    }

    public String getLastname(){
        return this.lastname;
    }

    public String getFirstname(){
        return this.firstname;
    }

    public int getAge(){
        return this.age;
    }

    public String getEntryYear(){
        return this.entryYear;
    }

    public abstract double getUnit();
}
