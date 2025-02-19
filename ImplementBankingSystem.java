import java.util.HashMap;
import java.util.TreeMap;
import java.util.LinkedList;
import java.util.Queue;

public class ImplementBankingSystem {
    private HashMap<Integer, Double> accounts = new HashMap<>();
    private TreeMap<Double, Integer> sortedAccounts = new TreeMap<>();
    private Queue<Integer> withdrawalQueue = new LinkedList<>();

    public void createAccount(int accountNumber, double initialBalance) {
        accounts.put(accountNumber, initialBalance);
        sortedAccounts.put(initialBalance, accountNumber);
    }

    public void deposit(int accountNumber, double amount) {
        if (accounts.containsKey(accountNumber)) {
            double newBalance = accounts.get(accountNumber) + amount;
            sortedAccounts.remove(accounts.get(accountNumber));
            accounts.put(accountNumber, newBalance);
            sortedAccounts.put(newBalance, accountNumber);
        } else {
            System.out.println("Account not found.");
        }
    }

    public void withdraw(int accountNumber, double amount) {
        if (accounts.containsKey(accountNumber)) {
            if (accounts.get(accountNumber) >= amount) {
                double newBalance = accounts.get(accountNumber) - amount;
                sortedAccounts.remove(accounts.get(accountNumber));
                accounts.put(accountNumber, newBalance);
                sortedAccounts.put(newBalance, accountNumber);
            } else {
                System.out.println("Insufficient funds.");
            }
        } else {
            System.out.println("Account not found.");
        }
    }

    public void addWithdrawalRequest(int accountNumber) {
        withdrawalQueue.add(accountNumber);
    }

    public void processWithdrawals() {
        while (!withdrawalQueue.isEmpty()) {
            int accountNumber = withdrawalQueue.poll();
            
            withdraw(accountNumber, 100.0);
        }
    }

    public void displayAccounts() {
        for (Integer accountNumber : accounts.keySet()) {
            System.out.println("Account Number: " + accountNumber + ", Balance: " + accounts.get(accountNumber));
        }
    }

    public void displaySortedAccounts() {
        for (Double balance : sortedAccounts.keySet()) {
            System.out.println("Balance: " + balance + ", Account Number: " + sortedAccounts.get(balance));
        }
    }
}
