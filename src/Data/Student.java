package Data;

import java.util.ArrayList;

/**
 * A class that refers to the students of university
 */
public class Student extends Person
{
    private String sID;
    private int sem;
    private ArrayList<Float> Grades;
    public Student(String sID, String name, String surName, String mail, String phoneNumber, int sem) {
        super(name, surName, mail, phoneNumber);
        this.sID = sID;
        this.sem = sem;
        Grades = new ArrayList<>();
    }

    /**
     * @return student's id
     */
    public String getsID() {
        return sID;
    }

    /**
     * @param sID student object's id.
     */
    public void setsID(String sID) {
        this.sID = sID;
    }

    /**
     * @return student object's semester.
     */
    public int getSem() {
        return sem;
    }

    /**
     * @param sem the semester to be set to student object.
     */
    public void setSem(int sem) {
        this.sem = sem;
    }

    /**
     * @return the Arraylist of Grades of a student object
     */
    public ArrayList<Float> getGrades() {
        return Grades;
    }

    /**
     * Searches a Student objects Courses for the given course and returns the Courses grade.
     * @param course The course it will search for
     * @return the grade of the given course for the specific Student object.
     */
    public float getCourseGrade(Course course) {
        for (Course crs : Courses)
        {
            if (course.equals(crs))
            {
                return Grades.get(Courses.indexOf(crs));
            }
        }
        return -1;
    }

    /**
     * Sets grades to student object's assigned courses.
     * @param course Course of student object
     * @param grade grade for that course
     */
    public void setGrades (Course course, float grade) {
        int i = 0;
        for (Course tmp: Courses)
        {
            if (course.equals(tmp)) {
                int j = Courses.indexOf(tmp);
                Grades.remove(j);
                Grades.add(j,grade);
            }
        }
        if (i == -1)
            System.out.println("Course Does Not Exist For This Student");
    }

    /**
     * Assigns courses to student and sets the grade to -1 (no grade added yet)
     * @param course the course that is assigned to Student object.
     */
    @Override
    public void setCourses(Course course) {
        super.setCourses(course);
        float x = -1.0f;
        Grades.add(x);
    }

    /**
     * Prints all the courses with their respective grades.
     */
    public void printGrades() {
        int i=0;
        for (Course tmp: Courses)
        {
            System.out.printf("%s, %s => %.2f\n", tmp.cID, tmp.cName, Grades.get(i));
            i++;
        }
    }

    /**
     * Prints the overall average grade. Courses without a grade (grade = -1)
     * arent taken into consideration.
     */
    public void printAverage() {
        float sum = 0;
        int i = 0;
        for (float grade:Grades) {
            if (grade != -1) {
                sum += grade;
                i++;
            }
        }
        float avg = (sum/i);
        System.out.println("Average: " + avg);
    }

    /**
     * prints the details of a student object.
     */
    public void print() {
        System.out.println("~~~~~~~~~~~");
        System.out.println("Student ID: " + sID);
        System.out.println("name: " + name);
        System.out.println("surName: " + surName);
        System.out.println("E-mail: " + mail);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Semester: " + sem);
        System.out.println("Courses:" + printCoursesToString());
        System.out.println("~~~~~~~~~~~");
    }

    /**
     * @return A string used to save Student objects into csv files.
     */
    @Override
    public String asCsvLine () {
        return sID + "," + super.asCsvLine() + "," + sem;
    }
}
