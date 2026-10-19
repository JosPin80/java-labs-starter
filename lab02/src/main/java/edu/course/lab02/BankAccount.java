package edu.course.lab02;

public class BankAccount {
    private int balance;

    public BankAccount(int balance) {
        if (balance < 0) {
            throw new IllegalArgumentException(
                    "Balance cannot be negative"
            );
        }

        this.balance = balance;
    }

    public void deposit(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(
                    "Amount cannot be negative"
            );
        }

        balance += amount;
    }

    public void withdraw(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(
                    "Amount cannot be negative"
            );
        }
        if (balance < amount) {
            throw new IllegalArgumentException(
                    "Balance - amount = negative"
            );
        }

        balance -= amount;
    }

    public int getBalance() {
        return balance;
    }
}
