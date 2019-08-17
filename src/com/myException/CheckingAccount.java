package com.myException;

/**
 * @ClassName CheckingAccount
 * @Author Gavin
 * @Date 2019/8/13 上午12:20
 **/
public class CheckingAccount {

    private int number;
    private double balance;

    public CheckingAccount(int number){
        this.number=number;
    }

    public void deposit(double amount){
        balance+=amount;
    }

    public void withdraw(double amount) throws InsufficientFundsException{

        if (amount<=balance){
            balance-=amount;
        }else {
            double needs= amount-balance;
            throw new InsufficientFundsException(needs);
        }

    }
    //方法：返回余额
    public double getBalance()
    {
        return balance;
    }
    //方法：返回卡号
    public int getNumber()
    {
        return number;
    }


}

