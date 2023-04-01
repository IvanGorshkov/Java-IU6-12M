package com.java.lab;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Main {
    private static final Random random = new Random();

    public static void main(String[] args) {
        Bank bank = new Bank(1000);

        Thread depositThread = new Thread(() -> {
            while (true) {
                try {
                    bank.deposit(random.nextInt(100));
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread withdrawThread = new Thread(() -> {
            while (true) {
                try {
                    bank.withdraw(random.nextInt(100));
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        depositThread.start();
        withdrawThread.start();
    }
}
 class Bank {
    private int balance;
    private final Semaphore withdrawSemaphore = new Semaphore(1);
    private final Semaphore depositSemaphore = new Semaphore(1);

    public Bank(int balance) {
        this.balance = balance;
    }

    public void deposit(int amount) throws InterruptedException {
        depositSemaphore.acquire();
        balance += amount;
        System.out.println("Depositing " + amount + " New balance: " + balance);
        depositSemaphore.release();
    }

    public void withdraw(int amount) throws InterruptedException {
        withdrawSemaphore.acquire();
        if (balance < amount) {
            System.out.println("Balance less then amount. Current balance: " + balance);
            withdrawSemaphore.release();
            return;
        }
        balance -= amount;
        System.out.println("Withdrawing " + amount + " New balance: " + balance);
        withdrawSemaphore.release();
    }
}