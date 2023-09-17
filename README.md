# Unibook - User Guide
Panagiotis Karapiperis - mscict22024

## About
Unibook is a University personnel data manipulation console application, developed in the context of the course 
"Introduction To Object-Oriented Programming" of masters program "Applied Informatics - University Of West Attica".
More info can be found in [JavaDoc](/JavaDoc) Directory

## Main Page
By running the program you first see the Main Menu page:
```console
Loaded Courses...
Loaded Students...
Loaded Grades...
Loaded Professors...
Loaded Professor's Courses...
  ~~~UniBook~~~  
 ~~~Main Menu~~~ 
[1] Students.....
[2] Professors...
[3] Courses......
[9] Save & EXIT..
Enter Choice: 
```
Notice the first 5 lines are used as an indicator that the pre-made demo data have been loaded successfully.

## Students Menu
By typing `1` you are directed into the `Students Menu` page, where you have a range of options for editing Student Data.
```console
        ~~~Students Menu~~~        
[1] Add New Student................
[2] Edit Existing Student..........
[3] Delete Student.................
[4] Show All Students..............
[5] Assign Course To Student.......
[6] Add Grades.....................
[7] Show Student's Average Grade...
[9] .............EXIT..............
Enter Choice: 
```
### Add New Student
By typing `1` you are directed into the `Add New Student` page. There you will be faced with a form for creating a new 
Student.
```console
~~~New Student~~~
Student ID: 
1234
Name: 
Panagiotis
Surname: 
Karapiperis
Mail: 
mscict22024@edu.uoa.gr
Phone Number: 
6937483294
Semester: 
2
```
Notice after the last insert the new student data will be logged as a receipt:
```console 
Student Added Successfully
~~~~~~~~~~~
Student ID: 1234
name: Panagiotis
surName: Karapiperis
E-mail: mscict22024@edu.uoa.gr
Phone Number: 6937483294
Semester: 2
Courses:
~~~~~~~~~~~
Press Enter to Continue...
```
Pressing `Enter` will redirect you to the main menu

### Edit Existing Student
By typing `2` you are directed into the `Edit Existing Student` page. There you will be faced with a form for editing
an existing Student.
```console
~~~Edit Student~~~
Enter Student ID: 
0001
New Name: 
john
New Surname: 
dillinger
New Mail: 
john@home.com
New Phone Number: 
9847293047
New Semester: 
5
Student Updated Successfully
~~~~~~~~~~~
Student ID: 0001
name: john
surName: wick
E-mail: john@home.com
Phone Number: 9847293047
Semester: 5
Courses: DemoCourse2 DemoCourse3
~~~~~~~~~~~
Press Enter to Continue...
```
If the student Id you inserted doesnt match to an existing student a message will be logged:
```console
~~~Edit Student~~~
Enter Student ID: 
5
Student Doesn't Exist
Press Enter to Continue...
```
### Delete Student
By typing `3` you are directed into the `Delete Student` page. There you will be faced with a form for deleting
an existing Student.
```console
~~~Delete Student~~~
Enter Student ID: 
0001
Student Deleted Successfully
Press Enter to Continue...
```
If the student Id you inserted doesnt match to an existing student a message will be logged:
```console
~~~Delete Student~~~
Enter Student ID: 
5
Student Not Found
Press Enter to Continue...
```
### Show All Students
By typing `4` you are directed into the `Show All Students` page:
```console
~~~~~~~~~~~
Student ID: 0002
name: stud2name
surName: stud2sname
E-mail: stud2@mail.com
Phone Number: 6922222
Semester: 3
Courses: DemoCourse1 DemoCourse2
~~~~~~~~~~~
~~~~~~~~~~~
Student ID: 0003
name: stud3name
surName: stud3sname
E-mail: stud3@mail.com
Phone Number: 6933333
Semester: 5
Courses: DemoCourse3 DemoCourse4
~~~~~~~~~~~
Press Enter to Continue...
```
### Assign Course To Student
By typing `5` you are directed into the `Assign Course To Student` page:
```console
~~~Assign Course to Student~~~
Enter Student ID: 
0002
Enter Course ID:
001
Course Added Successfully
~~~~~~~~~~~
Student ID: 0002
name: stud2name
surName: stud2sname
E-mail: stud2@mail.com
Phone Number: 6922222
Semester: 3
Courses: DemoCourse1 DemoCourse2 DemoCourse1
~~~~~~~~~~~
Press Enter to Continue...
```
If you enter invalid Student or Course id a message will be loged:
```console
~~~Assign Course to Student~~~
Enter Student ID: 
5
Student Not Found
Press Enter to Continue...
```
### Add Grades
By typing `6` you are directed into the `Set Grades` page:
```console
~~~Set Grade~~~
Enter Student ID: 
0002
stud2name stud2sname assigned courses:
001 - DemoCourse1
002 - DemoCourse2
Enter Course ID: 
001
Enter Grade: 
5
Grade Added Successfully
Press Enter to Continue...
```
### Show Student's Average Grade
By typing `7` you are directed into the `Set Grades` page:
```console
~~~Student Grades~~~
Enter Student ID
0002
stud2name stud2sname's Grades: 
001, DemoCourse1 => 5,00
002, DemoCourse2 => 7,00
Average: 6.0
Press Enter to Continue...
```

## Professors Menu
By typing `2` in the Main menu you are directed into the `Professors Menu` where you can edit professors data.
```console
        ~~~Professors Menu~~~        
[1] Add New Professor................
[2] Edit Existing Professor..........
[3] Delete Professor.................
[4] Show All Professors..............
[5] Assign Course To Professor.......
[9] ..............EXIT...............
Enter Choice: 
```
Here the functionality of each sub menu is similar to the `Students Menu`.
```console
~~~New Professor~~~
Professor ID: 
12345
Name: 
panos
Surname: 
kar
Mail: 
pkar@hotmail.com
Phone Number: 
23482374932
Specification: 
Physics
Professor Added Successfully
~~~~~~~~~~~
Professor ID: 12345
name: panos
surName: kar
E-mail: pkar@hotmail.com
Phone Number: 23482374932
Specification: Physics
Courses:
~~~~~~~~~~~
Press Enter to Continue...
```
## Courses Menu
By typing `3` in the Main menu you are directed into the `Courses Menu` where you can edit courses data.
```console
        ~~~Courses Menu~~~         
[1] Add New Course.................
[2] Edit Existing Course...........
[3] Delete Course..................
[4] Show All Courses...............
[5] Assign Professor To Course.....
[6] Show Courses Average Grade.....
[9] .............EXIT..............
Enter Choice: 
```
Here the functionality of each sub menu is similar to the `Students Menu`, with the addition of the `Show Courses Average Grade` Menu:
```console
~~~Course Average~~~
DemoCourse1 5,50
DemoCourse2 6,75
DemoCourse3 8,25
DemoCourse4 8,50
Press Enter to Continue...
```