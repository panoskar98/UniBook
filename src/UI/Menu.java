package UI;

import java.util.Scanner;

/**
 * The class that contains the main menu ui and all the sub menus.
 */
public class Menu extends Main {
    Scanner input = new Scanner(System.in);
    MenuMethods meth = new MenuMethods();

    /**
     * A method that initializes the addition of demo objects, and the loading of objects from csv files.
     */
    public void Init() {
        meth.demoObjects();
        meth.loadCourses();
        meth.loadStudents();
        meth.loadGrades();
        meth.loadProfessors();
        meth.loadProfessorCourses();
    }
    /**
     * Main menu UI that prompts user to choose between Students,Professors or Courses menus.
     */
    public void mainMenu() {
        int choice;
        System.out.println("  ~~~UniBook~~~  ");
        System.out.println(" ~~~Main Menu~~~ ");
        System.out.println("[1] Students.....");
        System.out.println("[2] Professors...");
        System.out.println("[3] Courses......");
        System.out.println("[9] Save & EXIT..");
        do
        {
            System.out.println("Enter Choice: ");
            choice = input.nextInt();
            Clear();
            switch (choice)
            {
                case 1: studentsMenu();break;
                case 2: professorsMenu();break;
                case 3: coursesMenu();break;
                case 9: meth.saveAllData();break;
                default: System.out.println("Invalid Input");break;
            }
        }
        while (choice < 1 || choice >3 && choice != 9);
    }

    /**
     * A UI main-menu sub-menu method for student editing
     */
    public void studentsMenu() {
        int ch;
        System.out.println("        ~~~Students Menu~~~        ");
        System.out.println("[1] Add New Student................");
        System.out.println("[2] Edit Existing Student..........");
        System.out.println("[3] Delete Student.................");
        System.out.println("[4] Show All Students..............");
        System.out.println("[5] Assign Course To Student.......");
        System.out.println("[6] Add Grades.....................");
        System.out.println("[7] Show Student's Average Grade...");
        System.out.println("[9] .............EXIT..............");
        do
        {
            System.out.println("Enter Choice: ");
            ch = input.nextInt();
            Clear();
            switch(ch)
            {
                case 1: meth.doAddStudent();break;
                case 2: meth.doEditStudent();break;
                case 3: meth.doDeleteStudent();break;
                case 4: meth.doShowStudents();break;
                case 5: meth.doAssignCourseToStudent();break;
                case 6: meth.doSetGradeToCourse();break;
                case 7: meth.doShowStudentGrades();break;
                case 9: break;
                default: System.out.println("Invalid Input");break;
            }
        } while(ch < 1 || ch > 7 && ch != 9 );
        pause();
    }

    /**
     * A UI main-menu sub-menu method for Professor editing
     */
    public void professorsMenu() {
        int ch;
        System.out.println("        ~~~Professors Menu~~~        ");
        System.out.println("[1] Add New Professor................");
        System.out.println("[2] Edit Existing Professor..........");
        System.out.println("[3] Delete Professor.................");
        System.out.println("[4] Show All Professors..............");
        System.out.println("[5] Assign Course To Professor.......");
        System.out.println("[9] ..............EXIT...............");
        do
        {
            System.out.println("Enter Choice: ");
            ch = input.nextInt();
            Clear();
            switch(ch)
            {
                case 1:meth.doAddProfessor();break;
                case 2:meth.doEditProfessor();break;
                case 3:meth.doDeleteProfessor();break;
                case 4:meth.doShowProfessors();break;
                case 5:meth.doAssignCourseToProfessor();break;
                case 9:break;
                default: System.out.println("Invalid Input");break;
            }
        }while(ch < 1 || ch > 5 && ch != 9);
        pause();
    }

    /**
     * A UI main-menu sub-menu method for Courses editing
     */
    public void coursesMenu() {
        int ch;
        System.out.println("        ~~~Courses Menu~~~         ");
        System.out.println("[1] Add New Course.................");
        System.out.println("[2] Edit Existing Course...........");
        System.out.println("[3] Delete Course..................");
        System.out.println("[4] Show All Courses...............");
        System.out.println("[5] Assign Professor To Course.....");
        System.out.println("[6] Show Courses Average Grade.....");
        System.out.println("[9] .............EXIT..............");
        do
        {
            System.out.println("Enter Choice: ");
            ch = input.nextInt();
            Clear();
            switch(ch)
            {
                case 1: meth.doAddCourse();break;
                case 2: meth.doEditCourse();break;
                case 3: meth.doDeleteCourse();break;
                case 4: meth.doShowCourses();break;
                case 6: meth.doShowCourseAverage();break;
                case 9: break;
                default: System.out.println("Invalid Input");break;
            }
        } while(ch < 1 || ch > 6 && ch != 9 );
        pause();
    }
    /**
     * A method used to clear the buffer after calling nextInt scanner method.
     */
    public void Clear(){
        input.nextLine();
    }

    /**
     * A method that prompts user to press enter to continue
     */
    public void pause() {
        System.out.println("Press Enter to Continue...");
        input.nextLine();
        mainMenu();
    }
}
