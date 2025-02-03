import java.util.Scanner;

class BankAccount{
    private static String bankName = "Global Bank";
    private static int totalAccounts = 0;

    private String accountHolderName;
    private final int accountNumber;

    public BankAccount(String accountHolderName) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = 0;
        totalAccounts++;
    }

    public BankAccount(String accountHolderName, int accountNumber) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        totalAccounts++;
    }


    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public static String getBankName() {
        return bankName;
    }

    public static void setBankName(String bankName) {
        BankAccount.bankName = bankName;
    }


    public static int getTotalAccounts() {
        return totalAccounts;
    }

    public void displayAccountDetails() {
        if (this instanceof BankAccount) {
            System.out.println("Account Holder Name: " + getAccountHolderName());
            System.out.println("Account Number: " + getAccountNumber());
            System.out.println("Bank Name: " + getBankName());
        }
       
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of the account holder: ");
        String name = sc.nextLine();
        sc.close();
        BankAccount account1 = new BankAccount(name);
        BankAccount account2 = new BankAccount("Jane Doe");

        account1.displayAccountDetails();
        account2.displayAccountDetails();
    }
}