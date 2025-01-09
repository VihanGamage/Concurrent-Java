package BankingSystem;

import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private final int id;
    private double balance;
    //fair reentrant lock
    private final ReentrantLock lock = new ReentrantLock(true);

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
        if (balance >= amount) {  //checking if the amount is smaller than balance
            balance = balance - amount;
        }
    }

    public void lock(){
        lock.lock();  //locking
    }

    public void unlock(){
        lock.unlock();  //unlocking
    }

}
