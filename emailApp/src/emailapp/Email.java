package emailapp;

import java.util.Scanner;

public class Email {
    private String firstName; //Encapsulated variables
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity = 500;
    private String alternateEmail;
    private int defaultPasswordLength = 10;
    private String companySuffix = "aeycompany.com";

    //Constructor to receive first and last name
    public Email(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;

        //Call method asking for department - return department
        this.department = setDepartment();

        //Call method for random password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is " + this.password);

        //Combine elements to generate email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
    }
    //Ask for the department
    private String setDepartment(){
        System.out.print("New worker: " + firstName + ". \nDepartment codes: \n1 for Sales" +
                "\n2 for Development\n3 for Accounting\n0 for none\nEnter department code: ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if (depChoice == 1){ return "sales"; }
        else if (depChoice == 2){ return "dev"; }
        else if (depChoice == 3){ return "acct"; }
        else { return ""; }
    }

    //Generate random password
    private String randomPassword(int length){
        String passwordSet ="ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890@#$%^&*()";
        char[] password = new char[length];
        for (int i=0; i<length; i++){
            int rand = (int)(Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    //Set mailbox capacity
    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity = capacity;
    }

    //Set an alternative email
    public void setAlternateEmail(String altEmail){
        this.alternateEmail = altEmail;
    }
    //Change password
    public void changePassword(String password){
        this.password = password;
    }
    //Getters
    public int getMailboxCapacity() { return  mailboxCapacity; }
    public String getAlternateEmail() { return  alternateEmail; }
    public String getPassword() { return  password; }

    public String showInfo(){
        return "DISPLAY NAME: " + firstName + " " + lastName +
        "\nCOMPANY EMAIL: " + email +
        "\nMAILBOX CAPACITY: " + mailboxCapacity + "mb";
    }
}
