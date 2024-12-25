package BankingSystem;

import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private final int id;
    private double balance;
    private final ReentrantLock lock = new ReentrantLock();

    public BankAccount(int id,double balance){
        this.id= id;
        this.balance= balance;
    }

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount){
        balance = balance + amount;
    }

    public void withdraw(double amount){
        if (balance >= amount) {
            balance = balance - amount;
        }
    }

    public void lock(){
        lock.lock();
    }

    public void unlock(){
        lock.unlock();
    }

}
