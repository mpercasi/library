package com.example.library.entity;

import com.example.library.configuration.DataSourceConfig;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class Customer {
    private String name;
    private String dni;
    private String address;
    private List<Loan> loans = new ArrayList<>();

//    @Autowired
//    private Environment environment;

    public Customer() {
    }

    public Customer(String name, String dni, String address) {
        this.name = name;
        this.dni = dni;
        this.address = address;
    }

//    @Override
//    public void setup() {
//        System.out.println("Currently profile is " + environment);
//    }
}
