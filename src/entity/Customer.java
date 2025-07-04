package entity;

import exception.GlobalSystemException;

public class Customer {

    private String name;
    private final String password = "2011";
    private double balance;

    public Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public boolean isBuy(double amount) {
        return balance >= amount;
    }
    public void reduceBalance(double amount) {
        balance -= amount;
    }

    public boolean isPasswordValid(String input) {
        if (password != null && password.equals(input))
             return true;
        throw new GlobalSystemException("Customer:checkPassword invalid credentials please try again.");
    }
}
