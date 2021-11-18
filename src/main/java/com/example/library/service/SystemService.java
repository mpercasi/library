package com.example.library.service;

import com.example.library.configuration.DataSourceConfig;
import com.example.library.entity.Customer;
import com.example.library.entity.Loan;
import com.example.library.entity.LoanItem;
import com.example.library.repository.CustomerRepository;
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
    private CustomerRepository customerRepository;

    @Autowired
    private Environment environment;

    public Customer addCustomer(Customer customer){
        //systemCurstomers.add(customer);
        customerRepository.save(customer);
        return customer;
    }

    public List<Customer> searchCustomer(String dni){
        return customerRepository.findCustomerByDNI(dni);
        //return systemCurstomers.stream().filter(d -> d.getDni().equals(dni)).findFirst();
    }

    @Override
    public void setup() {
        for (String profileName : environment.getActiveProfiles()) {
            System.out.println("Currently active profile - " + profileName);
        }
    }

    public void uptateCustomer(Customer customer) {
        customerRepository.updateCustomer(customer.getName(), customer.getDni(), customer.getAddress());
    }

    public void deleteCustomer(String dni) {
        customerRepository.deleteCustomer(dni);
    }
}
