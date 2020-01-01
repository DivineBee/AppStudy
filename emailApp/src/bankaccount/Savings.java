package bankaccount;

public class Savings extends Account {
    //List properties specific to savings account
    private int safetyDepositBoxID;
    private int safetyDepositBoxKey;
    //Constructor to init settings for savings properties
    public Savings(String name, String sSN, double initDeposit){
        super(name,sSN, initDeposit);
        accountNumber = "1" + accountNumber;
        setSafetyDepositBox();
    }

    @Override
    public void setRate(){
        rate = getBaseRate() - .25;
    }

    private void setSafetyDepositBox(){
        safetyDepositBoxID = (int) (Math.random() * Math.pow(10,3)); //Multiply by 3 'caus we want 3 digits
        safetyDepositBoxKey = (int) (Math.random() * Math.pow(10,4));
    }
    //List any methods specific to saving account
    public void showInfo(){
        super.showInfo();
        System.out.println(
                "Your saving account features" +
                "\nSafety deposit box ID: " + safetyDepositBoxID +
                "\nSafety deposit box key: " + safetyDepositBoxKey
        );
    }
}
