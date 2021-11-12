package com.example.library.repository;

import com.example.library.entity.Customer;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Optional;

@Component
@Getter @Setter
public class CustomerRepository {
    private ArrayList<Customer> customersList = new ArrayList<>();


}
