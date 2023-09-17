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


