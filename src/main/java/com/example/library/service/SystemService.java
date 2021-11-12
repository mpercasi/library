package com.example.library.service;

import com.example.library.entity.Customer;
import com.example.library.entity.Loan;
import com.example.library.entity.LoanItem;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Getter @Setter
public class SystemService {
    private List<Loan> systemLoans = new ArrayList<>();
    private List<Customer> systemCurstomers = new ArrayList<>();
    private List<LoanItem> systemItems = new ArrayList<>();

    public void addCustomer(Customer customer){
        systemCurstomers.add(customer);
    }

    public Optional<Customer> searchCustomer(String dni){
        return systemCurstomers.stream().filter(d -> d.getDni().equals(dni)).findFirst();
    }
}
