package UI;

import Data.Course;
import Data.Person;
import Data.Professor;
import Data.Student;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * A class that is used to store methods used in the Menu class.
 */
public class MenuMethods
{
    Scanner input = new Scanner(System.in);
    /**
     * An Arraylist that contains all courses objects.
     */
    public ArrayList<Course> AllCourses;
    /**
     * An ArrayList that contains all Person objects.
     */
    public ArrayList<Person> AllPeople;


    /**
     * Creates csv files to save all Courses, Students, Professors,
     * Courses assigned to Professors, Courses assigned to students with grades.
     */
    public void saveAllData() {
        saveCourses ();
        saveStudents ();
        saveProfessors();
        saveCourseGrades();
        saveProfessorCourses();
        System.out.println("All Changes Saved Successfully...");
    }

    /**
     * Creates a csv file to save all Course Objects.
     */
    public void saveCourses () {

        try (PrintWriter Pr = new PrintWriter("src/courses.csv"))
        {
            for (Course tmp: AllCourses)
            {
                Pr.println(tmp.asCsvLine());
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Cannot Open Courses File");
            System.exit(1);
        }
    }

    /**
     * Creates a csv file to save all Student Objects.
     */
    public void saveStudents () {

        try (PrintWriter Pr = new PrintWriter("src/students.csv"))
        {
            for (Student tmp: getAllStudents())
            {
                Pr.println(tmp.asCsvLine());
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Cannot Open Students File");
            System.exit(1);
        }
    }

    /**
     * Creates a csv file to save all Student Objects.
     */
    public void saveProfessors () {

        try (PrintWriter Pr = new PrintWriter("src/professors.csv"))
        {
            for (Professor tmp: getAllProfessors())
            {
                Pr.println(tmp.asCsvLine());
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Cannot Open Professors File");
            System.exit(1);
        }
    }

    /**
     * Creates a csv file that wrights student id, course id, grade
     */
    public void saveCourseGrades () {
        try (PrintWriter Pr = new PrintWriter("src/grades.csv"))
        {
            for (Student tmp: getAllStudents())
            {
                for (Course crs : tmp.getCourses())
                {
                    Pr.println(tmp.getsID() + "," + crs.getcID() + "," + tmp.getCourseGrade(crs));
                }
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Cannot Open grades File");
            System.exit(1);
        }
    }

    /**
     * Creates a csv file and saves the courses assigned to eatch professor.
     */
    public void saveProfessorCourses () {
        try (PrintWriter Pr = new PrintWriter("src/profcourses.csv"))
        {
            for (Professor pro: getAllProfessors())
            {
                for (Course crs : pro.getCourses())
                {
                    Pr.println(pro.getpID() + "," + crs.getcID());
                }
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Cannot Open profcourses File");
            System.exit(1);
        }
    }

    /**
     * Loads Courses from courses.csv file.
     */
    public void loadCourses () {
        String id,name,tmp;
        int sem;
        Course crs;
        try (Scanner Scan = new Scanner (new File("src/courses.csv")))
        {
            while (Scan.hasNextLine ())
            {
                tmp = Scan.nextLine();
                String[] pos = tmp.split(",");
                id = pos[0];
                name = pos[1];
                sem = Integer.parseInt(pos[2]);
                crs = new Course (id,name,sem);
                AllCourses.add (crs);
            }
        }
        catch (FileNotFoundException ex)
        {
            System.out.println ("Cannot Open File...");
            System.exit (1);
        }
        catch (IOException ex)
        {
            System.out.println ("Severe IO Error...");
            System.exit (1);
        }
        catch (InputMismatchException ex)
        {
            System.out.println ("Data Error...: ");
            System.exit (1);
        }
        System.out.println ("Loaded Courses...");
    }

    /**
     * Loads Students from students.csv file.
     */
    public void loadStudents () {
        String id,name,surname,mail,phone,tmp;
        int sem;
        Student st;
        try (Scanner Scan = new Scanner (new File("src/students.csv")))
        {
            while (Scan.hasNextLine ())
            {
                tmp = Scan.nextLine();
                String[] pos = tmp.split(",");
                id = pos[0];
                name = pos[1];
                surname = pos[2];
                mail = pos[3];
                phone = pos[4];
                sem = Integer.parseInt(pos[5]);
                st = new Student(id,name,surname,mail,phone,sem);
                AllPeople.add (st);
            }
        }
        catch (FileNotFoundException ex)
        {
            System.out.println ("Cannot Open File...");
            System.exit (1);
        }
        catch (IOException ex)
        {
            System.out.println ("Severe IO Error...");
            System.exit (1);
        }
        catch (InputMismatchException ex)
        {
            System.out.println ("Data Error...: ");
            System.exit (1);
        }
        System.out.println ("Loaded Students...");
    }

    /**
     * Loads grades from grades.csv file.
     */
    public void loadGrades () {
        String sid,cid,tmp;
        float grade;
        Student st;
        try (Scanner Scan = new Scanner (new File("src/grades.csv")))
        {
            while (Scan.hasNextLine ())
            {
                tmp = Scan.nextLine();
                String[] pos = tmp.split(",");
                sid = pos[0];
                cid = pos[1];
                grade = Float.parseFloat(pos[2]);
                st = getStudentByID(sid);
                st.setCourses(getCourseByID(cid));
                st.setGrades(getCourseByID(cid),grade);
            }
        }
        catch (FileNotFoundException ex)
        {
            System.out.println ("Cannot Open File...");
            System.exit (1);
        }
        catch (IOException ex)
        {
            System.out.println ("Severe IO Error...");
            System.exit (1);
        }
        catch (InputMismatchException ex)
        {
            System.out.println ("Data Error...: ");
            System.exit (1);
        }
        System.out.println ("Loaded Grades...");
    }

    /**
     * Loads Professors from professors.csv file.
     */
    public void loadProfessors () {
        String id,name,surname,mail,phone,spec,tmp;
        Professor pro;
        try (Scanner Scan = new Scanner (new File("src/professors.csv")))
        {
            while (Scan.hasNextLine ())
            {
                tmp = Scan.nextLine();
                String[] pos = tmp.split(",");
                id = pos[0];
                name = pos[1];
                surname = pos[2];
                mail = pos[3];
                phone = pos[4];
                spec = pos[5];
                pro = new Professor(id,name,surname,mail,phone,spec);
                AllPeople.add(pro);
            }
        }
        catch (FileNotFoundException ex)
        {
            System.out.println ("Cannot Open File...");
            System.exit (1);
        }
        catch (IOException ex)
        {
            System.out.println ("Severe IO Error...");
            System.exit (1);
        }
        catch (InputMismatchException ex)
        {
            System.out.println ("Data Error...: ");
            System.exit (1);
        }
        System.out.println ("Loaded Professors...");
    }

    public void loadProfessorCourses () {
        String pid,cid,tmp;
        Professor pro;
        try (Scanner Scan = new Scanner (new File("src/profcourses.csv")))
        {
            while (Scan.hasNextLine ())
            {
                tmp = Scan.nextLine();
                String[] pos = tmp.split(",");
                pid = pos[0];
                cid = pos[1];
                pro = getProfessorByID(pid);
                pro.setCourses(getCourseByID(cid));
            }
        }
        catch (FileNotFoundException ex)
        {
            System.out.println ("Cannot Open File...");
            System.exit (1);
        }
        catch (IOException ex)
        {
            System.out.println ("Severe IO Error...");
            System.exit (1);
        }
        catch (InputMismatchException ex)
        {
            System.out.println ("Data Error...: ");
            System.exit (1);
        }
        System.out.println ("Loaded Professor's Courses...");
    }

    /**
     * Initializes 3 demo Student, 3 demo Professor and 4 demo Course objects and adds them to the AllPeople ArrayList.
     *
     */
    public void demoObjects() {
        AllCourses = new ArrayList<>();
        AllPeople = new ArrayList<>();
        /*AllCourses.add(new Course("001","DemoCourse1",1));
        AllCourses.add(new Course("002","DemoCourse2",2));
        AllCourses.add(new Course("003","DemoCourse3",3));
        AllCourses.add(new Course("004","DemoCourse4",4));
        Student S1 = new Student("0001","stud1name","stud1sname","stud1@mail.com","6911111", 1);
        Student S2 = new Student("0002","stud2name","stud2sname","stud2@mail.com","6922222",3);
        Student S3 = new Student("0003","stud3name","stud3sname","stud3@mail.com","6933333",5);
        Professor P1 = new Professor("1111","prof1name","prof1sname","prof1@mail.com","6901111","spec1");
        Professor P2 = new Professor("2222","prof2name","prof2sname","prof2@mail.com","6902222","spec2");
        Professor P3 = new Professor("3333","prof3name","prof3sname","prof3@mail.com","6903333","spec3");
        P1.setCourses(getCourseByID("001"));
        P1.setCourses(getCourseByID("003"));
        P2.setCourses(getCourseByID("002"));
        P3.setCourses(getCourseByID("004"));
        S1.setCourses(getCourseByID("002"));
        S1.setGrades(getCourseByID("002"),6.0f);
        S1.setCourses(getCourseByID("003"));
        S1.setGrades(getCourseByID("003"),7.0f);
        S2.setCourses(getCourseByID("001"));
        S2.setGrades(getCourseByID("001"),5.5f);
        S2.setCourses(getCourseByID("002"));
        S2.setGrades(getCourseByID("002"),7.5f);
        S3.setCourses(getCourseByID("003"));
        S3.setGrades(getCourseByID("003"),9.5f);
        S3.setCourses(getCourseByID("004"));
        S3.setGrades(getCourseByID("004"),8.5f);
        AllPeople.add(S1);
        AllPeople.add(S2);
        AllPeople.add(S3);
        AllPeople.add(P1);
        AllPeople.add(P2);
        AllPeople.add(P3);*/
    }

    /**
     * A form that prompts the user to add a new Student object.
     */
    public void doAddStudent() {
        String id;
        Student tmp,st;
        System.out.println("~~~New Student~~~");
        System.out.println("Student ID: ");
        id = input.next ();
        tmp = getStudentByID(id);
        if (tmp != null)
        {
            System.out.println("Student Already Exists");
            return;
        }
        st = new Student("","","","","",0);
        st.setsID(id);
        System.out.println("Name: ");
        st.setName(input.next());
        System.out.println("Surname: ");
        st.setSurName(input.next());
        System.out.println("Mail: ");
        st.setMail(input.next());
        System.out.println("Phone Number: ");
        st.setPhoneNumber(input.next());
        System.out.println("Semester: ");
        st.setSem(input.nextInt());
        input.nextLine();
        AllPeople.add(st);
        System.out.println("Student Added Successfully");
        st.print();

    }

    /**
     * A form that prompts the user to add a new Professor object.
     */
    public void doAddProfessor() {
        String id;
        Professor tmp,pro;
        System.out.println("~~~New Professor~~~");
        System.out.println("Professor ID: ");
        id = input.next ();
        tmp = getProfessorByID(id);
        if (tmp != null)
        {
            System.out.println("Professor Already Exists");
            return;
        }
        pro = new Professor("","","","","","");
        pro.setpID(id);
        System.out.println("Name: ");
        pro.setName(input.next());
        System.out.println("Surname: ");
        pro.setSurName(input.next());
        System.out.println("Mail: ");
        pro.setMail(input.next());
        System.out.println("Phone Number: ");
        pro.setPhoneNumber(input.next());
        System.out.println("Specification: ");
        pro.setSpec(input.next ());
        AllPeople.add(pro);
        System.out.println("Professor Added Successfully");
        pro.print();


    }

    /**
     * A form that prompts the user to add a new Course object.
     */
    public void doAddCourse() {
        String id;
        Course tmp,crs;
        System.out.println("~~~New Course~~~");
        System.out.println("Course ID: ");
        id = input.next();
        tmp = getCourseByID(id);
        if (tmp != null)
        {
            System.out.println("Course Already Exists");
            return;
        }
        crs = new Course("","",0);
        crs.setcID(id);
        System.out.println("Name: ");
        crs.setcName(input.next());
        System.out.println("Semester: ");
        crs.setSem(input.nextInt());
        input.nextLine();
        AllCourses.add(crs);
        System.out.println("Course Added Successfully");
        crs.print();
    }

    /**
     * Prints All Student Objects That Exist
     */
    public void doShowStudents() {
        Student tmp;
        for (int i =0 ; i < getAllStudents().size(); i++)
        {
            tmp = getAllStudents().get(i);
            tmp.print();
        }
    }

    /**
     * Prints All Professor Objects That Exist
     */
    public void doShowProfessors() {
        Professor tmp;
        for (int i =0 ; i < getAllProfessors().size(); i++)
        {
            tmp = getAllProfessors().get(i);
            tmp.print();
        }
    }

    /**
     * Prints All Course Objects That Exist
     */
    public void doShowCourses() {
        for (Course tmp: AllCourses)
        {
            tmp.print();
        }
    }

    /**
     * A form that prompts the user to edit an existing Student object.
     */
    public void doEditStudent() {
        String id;
        Student st;
        System.out.println("~~~Edit Student~~~");
        System.out.println("Enter Student ID: ");
        id = input.next();
        st = getStudentByID(id);
        if (st==null)
        {
            System.out.println("Student Doesn't Exist");
            return;
        }
        System.out.println("New Name: ");
        st.setName(input.next());
        System.out.println("New Surname: ");
        st.setSurName(input.next());
        System.out.println("New Mail: ");
        st.setMail(input.next());
        System.out.println("New Phone Number: ");
        st.setPhoneNumber(input.next());
        System.out.println("New Semester: ");
        st.setSem(input.nextInt());
        input.nextLine();
        System.out.println("Student Updated Successfully");
        st.print();
    }

    /**
     * A form that prompts the user to edit an existing Professor object.
     */
    public void doEditProfessor() {
        String id;
        Professor pro;
        System.out.println("~~~Edit Student~~~");
        System.out.println("Enter Student ID: ");
        id = input.next();
        pro = getProfessorByID(id);
        if (pro==null)
        {
            System.out.println("Professor Doesn't Exist");
            return;
        }
        System.out.println("New Name: ");
        pro.setName(input.next());
        System.out.println("New Surname: ");
        pro.setSurName(input.next());
        System.out.println("New Mail: ");
        pro.setMail(input.next());
        System.out.println("New Phone Number: ");
        pro.setPhoneNumber(input.next());
        System.out.println("New Specification: ");
        pro.setSpec(input.next ());
        System.out.println("Professor Updated Successfully");
        pro.print();
    }

    /**
     * A form that prompts the user to edit an existing Course object.
     */
    public void doEditCourse() {
        String id;
        Course crs;
        System.out.println("~~~Edit Course~~~");
        System.out.println("Enter Course ID: ");
        id = input.next();
        crs = getCourseByID(id);
        if (crs==null)
        {
            System.out.println("Course Doesn't Exist");
            return;
        }
        System.out.println("Name: ");
        crs.setcName(input.next());
        System.out.println("Semester: ");
        crs.setSem(input.nextInt());
        input.nextLine();
        System.out.println("Course Updated Successfully");
        crs.print();
    }

    /**
     * A form that prompts the user to enter a student id and then deletes the student object with that id.
     */
    public void doDeleteStudent() {
        String id;
        Student st;
        System.out.println("~~~Delete Student~~~");
        System.out.println("Enter Student ID: ");
        id = input.next();
        st = getStudentByID(id);
        if (st == null)
        {
            System.out.println("Student Not Found");
            return;
        }
        AllPeople.remove(st);
        System.out.println("Student Deleted Successfully");
    }

    /**
     * A form that prompts the user to enter a professor id and then deletes the professor object with that id.
     */
    public void doDeleteProfessor() {
        String id;
        Professor pro;
        System.out.println("~~~Delete Professor~~~");
        System.out.println("Enter Professor ID: ");
        id = input.next();
        pro = getProfessorByID(id);
        if (pro == null)
        {
            System.out.println("Professor Not Found");
            return;
        }
        AllPeople.remove(pro);
        System.out.println("Professor Deleted Successfully");
    }

    /**
     * A form that prompts the user to enter a course id and then deletes the course object with that id.
     */
    public void doDeleteCourse() {
        String id;
        Course crs;
        System.out.println("~~~Delete Course~~~");
        System.out.println("Enter Course ID: ");
        id = input.next();
        crs = getCourseByID(id);
        if (crs == null)
        {
            System.out.println("Course Not Found");
            return;
        }
        AllCourses.remove(crs);
        System.out.println("Course Deleted Successfully");
    }

    /**
     * A form that prompts the user to enter a Professor ID and a Course ID that then assigns the course to the Professor object.
     */
    public void doAssignCourseToProfessor() {
        Professor pro;
        Course crs;
        String pid,cid;
        System.out.println("~~~Assign Course To Professor~~~");
        System.out.println("Enter Professor's ID");
        pid = input.next();
        pro = getProfessorByID(pid);
        if (pro == null)
        {
            System.out.println("Professor Not Found");
            return;
        }
        System.out.println("Enter Course's ID");
        cid = input.next();
        crs = getCourseByID(cid);
        if (crs == null)
        {
            System.out.println("Course Not Found");
            return;
        }
        pro.setCourses(crs);
        pro.printCourses();
    }

    /**
     * A form that prompts the user to enter a Student ID and a Course ID that then assigns the Course to the Student object.
     */
    public void doAssignCourseToStudent() {
        String sid,cid;
        Student st;
        Course crs;
        System.out.println("~~~Assign Course to Student~~~");
        System.out.println("Enter Student ID: ");
        sid = input.nextLine();
        st = getStudentByID(sid);
        if (st == null)
        {
            System.out.println("Student Not Found");
            return;
        }
        System.out.println("Enter Course ID:");
        cid = input.next();
        crs = getCourseByID(cid);
        if (crs == null)
        {
            System.out.println("Course Not Found");
            return;
        }
        st.setCourses(crs);
        System.out.println("Course Added Successfully");
        st.print();
    }

    /**
     * A form that prompts the user to enter a Student ID a Course ID and a grade
     * and then adds the grade to the given course in the student's assigned courses list.
     */
    public void doSetGradeToCourse() {
        String sid,cid;
        float grade;
        Student st;
        Course crs;
        System.out.println("~~~Set Grade~~~");
        System.out.println("Enter Student ID: ");
        sid = input.next();
        st = getStudentByID(sid);
        if (st == null)
        {
            System.out.println("Student Not Found");
            return;
        }
        System.out.printf("%s %s assigned courses:\n",st.getName(),st.getSurName());
        st.printCourses();
        System.out.println("Enter Course ID: ");
        cid = input.next();
        crs = getCourseByID(cid);
        if (cid == null)
        {
            System.out.println("Course Not Found");
            return;
        }
        System.out.println("Enter Grade: ");
        grade = input.nextFloat();
        if (grade < 0.0f || grade > 10.0f) {
            System.out.println("Invalid Input");
            return;
        }
        st.setGrades(crs,grade);
        System.out.println("Grade Added Successfully");
    }

    /**
     * A form that prompts the user to enter a student ID and then prints all the student object's grades
     * per course and at the end it prints the average grade
     */
    public void doShowStudentGrades() {
        String sid;
        Student st;
        System.out.println("~~~Student Grades~~~");
        System.out.println("Enter Student ID");
        sid = input.next();
        st = getStudentByID(sid);
        if (st == null)
        {
            System.out.println("Student Not Found");
            return;
        }
        System.out.printf("%s %s's Grades: \n",st.getName(),st.getSurName());
        st.printGrades();
        st.printAverage();
    }

    /**
     * Prints a list with all Course objects and their average grades.
     */
    public void doShowCourseAverage() {
        System.out.println("~~~Course Average~~~");
        for (Course crs: AllCourses)
        {
            System.out.printf("%s %.2f\n",crs.getcName(),getCourseAverage(crs));
        }
    }

    /**
     * @param course The course to look for in all Student objects.
     * @return the average grade of that course.
     */
    public float getCourseAverage(Course course) {
        float avg = 0;
        float grade;
        int i = 0;
        for (Student st: getAllStudents())
        {
           grade = st.getCourseGrade(course);
           if (grade != -1)
           {
               avg += grade;
               i++;
           }
        }
        if (i != 0)
        {
            return avg/i;
        }
        return -1;
    }

    /**
     * @param id The Student ID of a Student Object
     * @return The Student object that has the given id if one is found, null if not.
     */
    public Student getStudentByID(String id) {
        for (Student tmp : getAllStudents())
            if (tmp.getsID().equals(id))
                return tmp;
        return null;
    }

    /**
     * @param id The Professor ID of a Professor Object
     * @return The Professor object that has the given id if one is found, null if not.
     */
    public Professor getProfessorByID(String id) {
        for (Professor pr: getAllProfessors())
            if (pr.getpID().equals(id))
                return pr;
        return null;
    }

    /**
     * @param id The Course ID of a Course Object
     * @return The Course object that has the given id if one is found, null if not.
     */
    public Course getCourseByID(String id) {
        for(Course crs: AllCourses)
            if(crs.getcID().equals(id))
                return crs;
        return null;
    }

    /**
     * @return An Arraylist with all the Student objects of the AllPeople Arraylist
     */
    public ArrayList<Student> getAllStudents() {
        ArrayList<Student> tmp;
        tmp = new ArrayList<>();
        for (Person st: AllPeople)
        {
            if (st instanceof Student)
                tmp.add((Student) st);
        }
        return tmp;
    }

    /**
     * @return An Arraylist with all the Professor objects of the AllPeople Arraylist
     */
    public ArrayList<Professor> getAllProfessors() {
        ArrayList<Professor> list = new ArrayList<>();
        for (Person tmp: AllPeople)
            if (tmp instanceof Professor)
                list.add((Professor) tmp);
        return list;
    }

}
