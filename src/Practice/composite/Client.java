package Practice.composite;

import java.util.ArrayList;
import java.util.List;

abstract class Account{

    abstract Integer getBalance();
}
class SavingAccount extends Account{

    private String acNo;
    private Integer balance;

    SavingAccount(String acNo, Integer balance ){
        this.balance = balance;
        this.acNo = acNo;
    }

    @Override
    Integer getBalance() {
        return this.balance;
    }
}

class CurrentAccount extends Account{

    private String acNo;
    private Integer balance;

    CurrentAccount(String acNo, Integer balance ){
        this.balance = balance;
        this.acNo = acNo;
    }

    @Override
    Integer getBalance() {
        return this.balance;
    }
}

class CompositeAccount extends Account{

    private List<Account> accounts = new ArrayList<>();


    public void addAccount(Account ac){
        accounts.add(ac);
    }

    public void removeAccount(Account ac){
        accounts.remove(ac);
    }

    @Override
    Integer getBalance() {
        Integer totalBalance = 0;
        for(Account ac: accounts){
            totalBalance+= ac.getBalance();
        }
        return  totalBalance;
    }
}
public class Client {

    public static void main(String[] args) {
        //
        CompositeAccount compositeAccount = new CompositeAccount();
        compositeAccount.addAccount(new SavingAccount("asd", 100));
        compositeAccount.addAccount(new SavingAccount("asfwe", 200));
        compositeAccount.addAccount(new CurrentAccount("asdsad", 300));

        System.out.println(compositeAccount.getBalance());

    }

}