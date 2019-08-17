package com.myException;

/**
 * @ClassName InsufficientFundsException
 * @Author Gavin
 * @Date 2019/8/13 上午12:20
 **/
public class InsufficientFundsException extends Exception {
    private double amount;
    public InsufficientFundsException(double amount)
    {
        this.amount = amount;
    }
    public double getAmount()
    {
        return amount;
    }
}

