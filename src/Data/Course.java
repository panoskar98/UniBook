package Data;

/**
 * A class that refers to the available courses of the university
 */
public class Course
{
    String cID;
    String cName;
    int sem;

    public Course(String cID, String cName, int sem) {
        this.cID = cID;
        this.cName = cName;
        this.sem = sem;
    }

    public String getcID() {
        return cID;
    }

    public void setcID(String cID) {
        this.cID = cID;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public int getSem() {
        return sem;
    }

    public void setSem(int sem) {
        this.sem = sem;
    }

    /**
     * prints course object's details.
     */
    public void print() {
        System.out.println("~~~~~~~~~~~");
        System.out.println("Course ID: " + cID);
        System.out.println("name: " + cName);
        System.out.println("Semester: " + sem);
        System.out.println("~~~~~~~~~~~");
    }

    /**
     * @return a string used to save course objects to csv files.
     */
    public String asCsvLine () {
        return cID + "," + cName + "," + sem;
    }
}
