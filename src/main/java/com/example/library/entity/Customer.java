package com.example.library.entity;

import com.example.library.configuration.DataSourceConfig;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter @Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name="Customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String name;
    private String dni;
    private String address;

    @ElementCollection
    @Column(name="loan")
    private List<Loan> loans = new ArrayList<>();

    public Customer() {
    }

    public Customer(Integer id, String name, String dni, String address) {
        this.id = id;
        this.name = name;
        this.dni = dni;
        this.address = address;
    }

//    @Override
//    public void setup() {
//        System.out.println("Currently profile is " + environment);
//    }
}
