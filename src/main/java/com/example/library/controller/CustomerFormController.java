package com.example.library.controller;

import com.example.library.entity.Customer;
import com.example.library.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CustomerFormController {

    @Autowired
    private SystemService systemService;

    @GetMapping("/userForm")
    public String getCustomerForm(Model model){
        model.addAttribute("customers", new Customer());
        return "customerForm";
    }

    @PostMapping("/userForm")
    public String saveCustomer(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes){
        systemService.addCustomer(customer);
        return "confirmation";
    }
}
