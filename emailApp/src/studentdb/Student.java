package studentdb;

import java.util.Scanner;

public class Student {
    private String firstName;
    private String lastName;
    private int gradeYear;
    private String studentID;
    private String courses = null;
    private int tuitionBalance = 0;
    private static int costOfCourse = 600;
    private static int id = 1000;

    //Constructor enter name and year
    Student(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter student first name: ");
        this.firstName = in.nextLine();

        System.out.println("Enter student last name: ");
        this.lastName = in.nextLine();

        System.out.println("1 - Freshmen\n2 - Sophmore\n3 - Jumior\n4 - Senior\nEnter student class level: ");
        this.gradeYear = in.nextInt();

        setStudentID();
    }

    //Generate an ID
    private void setStudentID(){
        //Grade Level + static ID
        id++;
        this.studentID = gradeYear + "" + id;
    }

    //Enroll in courses
    void enroll(){
        //Get inside a loop user hits 0
        do {
            System.out.print("Enter course to enroll(Q to quit): ");
            Scanner in = new Scanner(System.in);
            String course = in.nextLine();
            if (!course.equals("Q")) {
                courses = courses + "\n " + course;
                tuitionBalance = tuitionBalance + costOfCourse;
            }
            else{ break; }
        } while (1 != 0);
    }
    //View balance
    private void viewBalance() {
        System.out.println("Your balance is: $" + tuitionBalance);
    }
    //Pay tuition
    void payTuition() {
        viewBalance();
        System.out.print("Enter your payment: $");
        Scanner in = new Scanner(System.in);
        int payment = in.nextInt();
        tuitionBalance = tuitionBalance - payment;
        System.out.println("Thank you for your payment of $ " + payment);
        viewBalance();
    }
    //Show status
    public String toString() {
        return "Name: " + firstName + " " +lastName +
                "\nGrade level: " + gradeYear +
                "\nStudent ID: " + studentID +
                "\nCourses Enrolled: " +
                "\nYour Balance is: $" + tuitionBalance;
    }
}
