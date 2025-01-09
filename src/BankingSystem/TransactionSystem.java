package BankingSystem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransactionSystem {
    private final Map<Integer, BankAccount> accounts = new HashMap<>(); //hashmap

    public TransactionSystem(List<BankAccount> accountList){
        for (BankAccount account:accountList){
            accounts.put(account.getId(), account);
        }
    }

    public boolean transfer(int fromAccountId, int toAccountId, double amount){
        BankAccount fromAccount = accounts.get(fromAccountId);  //getting account id
        BankAccount toAccount = accounts.get(toAccountId);

        if (fromAccount==null || toAccount==null){  //checking accounts exits
            System.out.println("Invalid account ID");
            return false;
        }

        if (fromAccount.getBalance()<amount){  //checking funds are available
            System.out.println("Insufficient balance in Account "+fromAccountId+
                    " to transfer "+amount+" amount ");
            return false;
        }

        try {
            fromAccount.lock();  //locking both accounts
            toAccount.lock();
            fromAccount.withdraw(amount);
            toAccount.deposit(amount);
            System.out.println("Transferred $"+amount+" from account "+fromAccountId+
                    " to account "+toAccountId);
            return true;
        } finally {
            fromAccount.unlock();  //unlocking both accounts
            toAccount.unlock();
        }
    }

    public void reverseTransaction(int fromAccountId, int toAccountId, double amount){
        transfer(toAccountId,fromAccountId,amount);
    }

    public void printAccountBalances(){  //printing accounts balance
        for (BankAccount account : accounts.values()){
            System.out.println("AccountID "+account.getId()+" : balance - $"+account.getBalance());
        }
    }

}
