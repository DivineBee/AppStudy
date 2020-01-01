/**
 * Email Application
 * Study Nr.1
 * Theme: Create email accounts for new hires
 *
 * Generate email, Determine departments, Generate a random string for password,
 * Set methods to change password, mailbox capacity, alternative email,
 * Have get methods display name mail and capacity
 */
package emailapp;

public class EmailApp {
    public static void main(String[] args) {
        Email em1 = new Email("John", "Smith");
        System.out.println(em1.showInfo());
    }
}
