abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }

    public abstract void calculateInterest();
}

class SavingsAccount extends BankAccount {
    private static final double INTEREST_RATE = 0.04;

    public SavingsAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public void calculateInterest() {
        double interest = getBalance() * INTEREST_RATE;
        super.deposit(interest);
    }
}

class CurrentAccount extends BankAccount {
    private static final double INTEREST_RATE = 0.02;

    public CurrentAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public void calculateInterest() {
        double interest = getBalance() * INTEREST_RATE;
        deposit(interest);
    }
}

interface Loanable {
    void applyForLoan(double amount);
    double calculateLoanEligibility();
}

public class BankingSystem {
    public static void main(String[] args) {
        BankAccount savings = new SavingsAccount("SA123", "John Doe", 1000);
        BankAccount current = new CurrentAccount("CA123", "Jane Doe", 2000);

        savings.calculateInterest();
        current.calculateInterest();

        System.out.println("Savings Account Balance: " + savings.getBalance());
        System.out.println("Current Account Balance: " + current.getBalance());
    }
}