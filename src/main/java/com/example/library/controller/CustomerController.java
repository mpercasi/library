package com.example.library.controller;

import com.example.library.entity.Customer;
import com.example.library.repository.CustomerRepository;
import com.example.library.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/library")
public class CustomerController {

    private static final String DESCRIPTION = "User not found...";

    @Autowired
    private SystemService system;


    @GetMapping
    public List<Customer> getCustomer(){
        return system.getSystemCurstomers();
    }

//    @GetMapping("/{dni}")
//    public ResponseEntity<Customer> getCustomers(@PathVariable String dni) throws NonExistentCustomerException {
//        Optional<Customer> optionalCustomer = system.searchCustomer(dni);
//        if(optionalCustomer.isEmpty()){
//            throw new NonExistentCustomerException();
//        }
//        return ResponseEntity.ok(optionalCustomer.get());
//    }
//
    @GetMapping("/{dni}")
    public ResponseEntity<Customer> getCustomer(@PathVariable String dni) throws NonExistentCustomerException {

        List<Customer> optionalCustomer = system.searchCustomer(dni);
        if(optionalCustomer.isEmpty()){
            throw new NonExistentCustomerException();
            //return buildCustomerHandler(HttpStatus.NOT_FOUND, new RuntimeException("User not found"));
        }
        return ResponseEntity.ok(optionalCustomer.get(0));
    }

//    @PostMapping
//    public void createCustomer(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes){
//        system.addCustomer(customer);
//    }

//    @PostMapping
//    public void createCustomer(@RequestBody Customer customer){
//        system.addCustomer(customer);
//    }

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) throws CustomerDuplicatedException{
        System.out.println("Llegó una petición");
        List<Customer> c = system.searchCustomer(customer.getDni());
        if(!c.isEmpty()){
            throw new CustomerDuplicatedException();
            //return buildCustomerHandler(HttpStatus.NOT_FOUND, new RuntimeException("User not found"));
        }
        return ResponseEntity.ok(system.addCustomer(customer));
    }

    @PutMapping
    public ResponseEntity updateCustomer(@RequestBody Customer customer) throws NonExistentCustomerException{
        //Before -------------------------------------------
        //deleteCustomer(customer.getDni());
        //system.addCustomer(customer);
        //Before -------------------------------------------
        if (system.searchCustomer(customer.getDni()).isEmpty()){
            throw new NonExistentCustomerException();
        }
        system.uptateCustomer(customer);
        return ResponseEntity.ok("Customer updated successfully!");
    }

    @DeleteMapping("delete/{dni}")
    public ResponseEntity deleteCustomer(@PathVariable String dni) throws NonExistentCustomerException{
        //Before -------------------------------------------
        //Optional<Customer> optionalCustomer = system.searchCustomer(dni);
        //optionalCustomer.ifPresent(value -> system.getSystemCurstomers().remove(value));
        //Before -------------------------------------------

        if(system.searchCustomer(dni).isEmpty()){
            throw new NonExistentCustomerException();
            //return buildCustomerHandler(HttpStatus.NOT_FOUND, new RuntimeException("User not found"));
        }
        system.deleteCustomer(dni);
        return ResponseEntity.ok("User deleted successfully!");

    }


}
