package com.example.library.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class Customer {
    private String name;
    private String dni;
    private String address;
    private List<Loan> loans = new ArrayList<>();

    public Customer() {
    }

    public Customer(String name, String dni, String address) {
        this.name = name;
        this.dni = dni;
        this.address = address;
    }
}
