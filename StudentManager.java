/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package seisani10.studentmanager;

/**
 *
 * @author SEISANI GUNDO JR
 */



import  java.util.ArrayList;
import  java.util.Scanner;
public class StudentManager {
    private static Scanner scanner = new Scanner(System.in);
    private static String menu_option = "";
    private static String menu ;
    private int ID,age = 0;
    private String name,email,course = "";
    private ArrayList<Student> students = new ArrayList<>();

    //function that display  student management menu
    public void displayMenu() {
        System.out.println("STUDENT MANAGEMENT APPLICATION");
        System.out.println("********************************");
        System.out.println("Please enter Enter (1) to launch menu or any other key to exit");
        menu_option = scanner.nextLine();

        if (menu_option.equals("1")) {
            while (true) {
                System.out.println("Please select one of the following menu items:");
                menu = ("(1) Capture a new student \n" +
                        "(2) Search for a student  \n" +
                        "(3) Delete a student \n" +
                        "(4) Print student report \n" +
                        "(5) Exit Application ");
                System.out.println(menu);

                int option = scanner.nextInt();
                scanner.nextLine(); // consume newline

                switch (option) {
                    case 1: {
                        saveStudent();
                        break;
                    }
                    case 2: {
                        searchStudent();
                        break;
                    }
                    case 3:
                    {
                        //delete function
                        deleteStudent();
                        break;
                    }

                    case 4: {
                        //calling report function
                        studentReport();
                        break;
                    }
                    case 5:
                    {
                        ExitApplication();
                    }
                    default:
                        System.out.println("Invalid option Please try again.");
                }

                // After each action, re-prompt
                System.out.println("Please enter Enter (1) to launch menu or any other key to exit");
                menu_option = scanner.nextLine();

            }
        } else {
            System.out.println("You Exited");
        }
    }

    //************************************************************************************************************
   //function to that save student details
    public void saveStudent()
    {

        System.out.println("CAPTURE A NEW STUDENT \n"+
                "*************************");
        System.out.print("Enter the student id:" );
        ID = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter the student name:" );
        name = scanner.nextLine();


        System.out.print("Please Enter the student age: " );

        //calling age validation function
       age = age_validation();

        System.out.print("Enter the student email:");
        email = scanner.nextLine();


        System.out.print("Enter the student course:" );
        course = scanner.nextLine();




        students.add(new Student(ID,name,age,email,course));
        //******************************************
        //1.4 input success message
        System.out.println("Student details successfully\n\n");



    }
//**********************************************************************************
    //function that validate student age
    public static int age_validation() {


        while (true) {

            String input = scanner.nextLine().trim();

            try {
                int age = Integer.parseInt(input);
                if (age >= 16) {
                  return age;
                } else {
                    System.out.println("You have entered a incorrect student age !!!  ");
                    System.out.print("Please re-enter the student age >> ");
                }


            } catch (NumberFormatException nfE) {

                System.out.print("Please re-enter the student age >> ");
            }


        }



    }

    //************************************************************************************
    //function to search students

    public void searchStudent() {
        System.out.print("Enter Student ID to Search: ");
        ID = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.println("-----------------------------------------------------\n");

        boolean found = false;

        for (Student s : students) {
            if (s.getID() == ID) {
                System.out.print(s.display_Students() + "\n");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student with student ID : " + ID + " was not found \n");
        }

        System.out.println("-----------------------------------------------------\n");

        // Re-prompt after search
       /* System.out.println("Please enter Enter (1) to launch menu or any other key to exit");
        menu_option = scanner.nextLine();*/
    }
//**********************************************************************************************************************

//function to delete student details
    public void deleteStudent() {
        System.out.print("Enter Student ID to Delete: ");
        ID = scanner.nextInt();
        scanner.nextLine(); // consume newline

        boolean found = false;

        for (Student s : students) {
            if (s.getID() == ID) {
                System.out.println("Student Found:");
                System.out.println(s.display_Students());

                System.out.print("Are you sure you want to delete this student? (Y/N): ");
                String confirm = scanner.nextLine();
                System.out.println("-----------------------------------------------------\n");
                if (confirm.equalsIgnoreCase("Y")) {
                    students.remove(s);
                    System.out.println("Student with ID " + ID + " has been deleted.");
                } else {
                    System.out.println("Deletion cancelled.");
                }

                found = true;
                break;
            }

        }

        if (!found) {
            System.out.println("Student with ID " + ID + " was not found.");
        }

        System.out.println("-----------------------------------------------------\n");
    }
//***********************************************************************************************************
//function to view report
public void studentReport() {
    if (students.isEmpty()) {
        System.out.println("No students have been captured yet.");
    } else {
        System.out.println("Student  Report\n");//displaying every students

        int count = 1; // count start at one for default
        for (Student s : students) {
            System.out.println("STUDENT " + count);// this going to display student details individualy
            System.out.println("----------------------------------------------" +
                               "STUDENT ID    : " + s.getID()  + "\n" +
                               "STUDENT NAME  : " + s.getName()+ "\n" +
                               "STUDENT AGE   : " + s.getAge() + "\n" +
                               "STUDENT EMAIL : " + s.getEmail()+ "\n" +
                               "STUDENT COURSE: " + s.getCourse()+ "\n" +
                               "----------------------------------------------\n");
            count++;// then count is going to increase by 1 after capturing student details Student 1 , student 2 ,....
        }
    }


}

//**********************************************************************************************************************
    public  void ExitApplication(){
        System.out.println("Exiting application...");
        return;
    }

}





