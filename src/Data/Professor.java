package Data;

/**
 * A class that refers to the professors of university
 */
public class Professor extends Person
{
    private String pID;
    private String spec;

    public Professor(String pID, String name, String surName, String mail, String phoneNumber, String spec) {
        super(name, surName, mail, phoneNumber);
        this.pID = pID;
        this.spec = spec;
    }

    public String getpID() {
        return pID;
    }

    public void setpID(String pID) {
        this.pID = pID;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    /**
     * A method that prints all the Courses assigned to the Professor Object.
     */
    @Override
    public void printCourses(){
        System.out.printf("Professors %s %s Courses:%n",this.name,this.surName);
        super.printCourses();
    }

    /**
     * Prints all the details of a Professor Object
     */
    public void print() {
        System.out.println("~~~~~~~~~~~");
        System.out.println("Professor ID: " + pID);
        System.out.println("name: " + name);
        System.out.println("surName: " + surName);
        System.out.println("E-mail: " + mail);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Specification: " + spec);
        System.out.println("Courses:" + printCoursesToString());
        System.out.println("~~~~~~~~~~~");
    }

    /**
     * @return a string used to save professor objects to csv file.
     */
    @Override
    public String asCsvLine () {
        return pID + "," + super.asCsvLine() + "," + spec;
    }
}
