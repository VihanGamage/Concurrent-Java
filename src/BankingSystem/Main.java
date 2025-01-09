package BankingSystem;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        BankAccount account1 = new BankAccount(1,1000);  //creating bank accounts
        BankAccount account2 = new BankAccount(2,2000);
        BankAccount account3 = new BankAccount(3,3000);

        //arraylist for hold accounts
        TransactionSystem transactionSystem =
                new TransactionSystem(Arrays.asList(account1,account2,account3));

        Thread thread1 = new Thread(() ->   //lambda threads
                transactionSystem.transfer(1,2,500));
        Thread thread2 = new Thread(() ->
                transactionSystem.transfer(2,3,1500));
        Thread thread3 = new Thread(() ->
                transactionSystem.transfer(3,1,2500));
        Thread thread4 = new Thread(() ->
                transactionSystem.reverseTransaction(1,2,500));

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }

        transactionSystem.printAccountBalances();  //finally printing balances of accounts

    }
}
