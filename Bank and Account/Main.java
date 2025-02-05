import java.util.ArrayList;
import java.util.List;


class Bank {
    private String name;
    private List<Customer> customers;

    public Bank(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    public void openAccount(Customer customer, double initialDeposit) {
        Account newAccount = new Account(this, initialDeposit);
        customer.addAccount(newAccount);
        if (!customers.contains(customer)) {
            customers.add(customer);
        }
        System.out.println("Account opened for " + customer.getName() + " with initial deposit of " + initialDeposit);
    }

    public String getName() {
        return name;
    }
}

class Customer {
    private String name;
    private List<Account> accounts;

    public Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void viewBalance() {
        for (Account account : accounts) {
            System.out.println("Account balance: " + account.getBalance());
        }
    }

    public String getName() {
        return name;
    }
}

class Account {
    private Bank bank;
    private double balance;

    public Account(Bank bank, double initialDeposit) {
        this.bank = bank;
        this.balance = initialDeposit;
    }

    public double getBalance() {
        return balance;
    }
}

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank("MyBank");
        Customer customer1 = new Customer("John Doe");

        bank.openAccount(customer1, 1000.0);
        customer1.viewBalance();
    }
}