package com.example.library.controller;

public class NonExistentCustomerException extends Throwable {
    public String NonExistentCustomerException() {
        return "Customer not found --- Error 404";
    }
}
