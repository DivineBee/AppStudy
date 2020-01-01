package bankaccount;

public class Checking extends Account {
    //List properties specific to checking account
    private int debitCardNumber;
    private int getDebitCardPIN;
    //Constructor to initialize checking account properties
    public Checking(String name, String sSN, double initDeposit){
        super(name,sSN, initDeposit);
        accountNumber = "2" + accountNumber;
        setDebitCard();
    }

    @Override
    public void setRate(){
        rate = getBaseRate() * .15;
    }
    //List any methods specific to checking account
    private void setDebitCard(){
        debitCardNumber = (int) (Math.random() * Math.pow(10, 12));
        getDebitCardPIN = (int) (Math.random() * Math.pow(10, 4));
    }

    public void showInfo(){
        super.showInfo();
        System.out.println(
                "Your checking account features: "+
                "\nDebit card number: " + debitCardNumber +
                "\nDebit card PIN: " + getDebitCardPIN
        );
    }
}
