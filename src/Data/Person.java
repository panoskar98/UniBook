package Data;

import java.util.ArrayList;

/**
 * Parent class of classes Student and Professor
 */
public class Person {
    protected String name;
    protected String surName;
    protected String mail;
    protected String phoneNumber;
    /**
     * An arraylist that contains all the courses assigned to a person object
     */
    protected ArrayList<Course> Courses;

    /**
     *
     * @param name name of person object
     * @param surName surname of person object
     * @param mail mail of person object
     * @param phoneNumber phone number of person object
     */
    public Person(String name, String surName, String mail, String phoneNumber) {
        this.name = name;
        this.surName = surName;
        this.mail = mail;
        this.phoneNumber = phoneNumber;
        Courses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * @return an Arraylist with all of the Student object's courses.
     */
    public ArrayList<Course> getCourses(){
        return Courses;
    }

    public void setCourses(Course course){
        Courses.add(course);
    }

    /**
     * A method that prints all the Courses assigned to a Person Object.
     */
    public void printCourses(){
        for (Course tmp: Courses) {
            System.out.printf("%s - %s%n",tmp.cID,tmp.cName);
        }
    }

    /**
     * @return A string with all the courses assigned to Professor object separated by spaces.
     */
    public String printCoursesToString(){
        String crs = "";
        for (Course tmp: Courses) {
            crs = crs + " " + tmp.cName;
        }
        return crs;
    }

    public String asCsvLine () {
        return name + "," + surName + "," + mail + "," + phoneNumber;
    }
}
