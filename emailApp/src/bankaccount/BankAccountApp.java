package bankaccount;

import java.util.LinkedList;
import java.util.List;

public class BankAccountApp {
    public static void main(String[] args) {
        List<Account> accounts = new LinkedList<Account>();

    //Read csv file then create account based on that data
        String file = "D:\\playground\\emailApp\\src\\NewBankAccounts.csv";
        List<String[]> newAccHolders = utilities.CSV.read(file);
        for (String[] accHolder : newAccHolders) {
            String name = accHolder[0];
            String sSN = accHolder[1];
            String accountType = accHolder[2];
            double initDeposit = Double.parseDouble(accHolder[3]);
            if (accountType.equals("Savings")){
                accounts.add(new Savings(name, sSN, initDeposit));
            }
            else if (accountType.equals("Checking")){
                accounts.add(new Checking(name, sSN, initDeposit));
            }
            else {
                System.out.println("Error reading account type");
            }
        }
//For each item(acc) in accounts iterates and shows info
        for (Account acc : accounts){
            System.out.println("\n**************");
            acc.showInfo();
        }
    }
}
