package com.example.library.service;

import com.example.library.configuration.DataSourceConfig;
import com.example.library.entity.Customer;
import com.example.library.entity.Loan;
import com.example.library.entity.LoanItem;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Getter @Setter
public class SystemService implements DataSourceConfig{
    private List<Loan> systemLoans = new ArrayList<>();
    private List<Customer> systemCurstomers = new ArrayList<>();
    private List<LoanItem> systemItems = new ArrayList<>();

    @Autowired
    Environment environment;

    public void addCustomer(Customer customer){
        systemCurstomers.add(customer);
    }

    public Optional<Customer> searchCustomer(String dni){
        return systemCurstomers.stream().filter(d -> d.getDni().equals(dni)).findFirst();
    }

    @Override
    public void setup() {
        for (String profileName : environment.getActiveProfiles()) {
            System.out.println("Currently active profile - " + profileName);
        }
    }
}
