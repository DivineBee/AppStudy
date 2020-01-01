package bankaccount;
//We cant create anything from the abstract class
//Only general lines here which will be use in children classes
public abstract class Account implements IBaseRate{
    //List common properties for savings and checking accounts
    private String name;
    private String sSN;
    private double balance;
    private static int index = 10000;
    //Protected are only available to the class and its children
    protected String accountNumber;
    protected double rate;

    //Constructor to set base properties and initialize the account
    public Account(String name, String sSN, double initDeposit){
        index++;
        this.name = name;
        this.sSN = sSN;
        this.balance = initDeposit;
        this.accountNumber = setAccountNr();
        setRate();
    }

    public abstract void setRate(); //Must to implement it

    private String setAccountNr(){
        String lastTwoOfSSN = sSN.substring(sSN.length()-2,sSN.length());
        int uniqueID = index;
        int randomNumber = (int) (Math.random() * Math.pow(10, 3));
        return lastTwoOfSSN + uniqueID + randomNumber;
    }

    public void compound() {
        double accruedInterest = balance * (rate/100);
        balance = balance + accruedInterest;
        System.out.println("Accrued Interest: $" + accruedInterest);
        printBalance();
    }

    //List common methods -transactions
    public void deposit(double amount){
        balance = balance + amount;
        System.out.println("Depositing $" + amount);
        printBalance();
    }
    public void withdraw(double amount){
        balance = balance - amount;
        System.out.println("Withdrawing $" + amount);
        printBalance();
    }
    public void transfer(String toWhere, double amount){
        balance = balance - amount;
        System.out.println("Transfering $" + amount + " to " + toWhere);
        printBalance();
    }
    public void printBalance(){
        System.out.println("Your balance is now $" + balance);
    }

    public void showInfo(){
        System.out.println(
                "Name: " + name +
                "\nAccount number: " + accountNumber +
                "\nBalance: " + balance +
                "\nRate: " + rate + "%"
        );
    }
}
