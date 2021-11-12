package com.example.library.controller;

import com.example.library.entity.Customer;
import com.example.library.repository.CustomerRepository;
import com.example.library.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/library")
public class CustomerController {

    @Autowired
    private SystemService system;


    @GetMapping
    public List<Customer> getCustomer(){
        return system.getSystemCurstomers();
    }

    @GetMapping("/{dni}")
    public ResponseEntity<Customer> getCustomers(@PathVariable String dni) throws NonExistentCustomerException {
        Optional<Customer> optionalCustomer = system.searchCustomer(dni);
        if(optionalCustomer.isEmpty()){
            throw new NonExistentCustomerException();
        }
        return ResponseEntity.ok(optionalCustomer.get());
    }

//    @PostMapping
//    public void createCustomer(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes){
//        system.addCustomer(customer);
//    }

    @PostMapping
    public void createCustomer(@RequestBody Customer customer){
        system.addCustomer(customer);
    }

    @PutMapping
    public void updateCustomer(@RequestBody Customer customer){
        deleteCustomer(customer.getDni());
        system.addCustomer(customer);
    }

    @DeleteMapping("delete/{dni}")
    public void deleteCustomer(@PathVariable String dni){
        Optional<Customer> optionalCustomer = system.searchCustomer(dni);
        optionalCustomer.ifPresent(value -> system.getSystemCurstomers().remove(value));
    }


}
