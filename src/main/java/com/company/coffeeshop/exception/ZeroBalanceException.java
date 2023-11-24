package com.company.coffeeshop.exception;

public class ZeroBalanceException extends RuntimeException {

    public ZeroBalanceException() {
        super("Insufficient funds in your account");
    }
}
