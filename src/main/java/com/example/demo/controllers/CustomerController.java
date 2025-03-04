package com.example.demo.controllers;

import com.example.demo.models.Customer;
import com.example.demo.repositories.CustomerRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/registration")
public class CustomerController {
    
    private final CustomerRepository customerRepository;


    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @GetMapping
    public String showForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "registration";
    }


    @PostMapping
    public String submitForm(@Valid @ModelAttribute("customer") Customer customer, 
                            BindingResult result,
                            Model model) {
        

        if (result.hasErrors()) {
            return "registration";
        }


        if (customerRepository.findByEmailAddressIgnoreCase(customer.getEmailAddress().toLowerCase()).isPresent()) {
            model.addAttribute("error", "Email already exists!");
            return "registration";
        }


        customerRepository.save(customer);
        return "redirect:/registration/success";
    }


    @GetMapping("/success")
    public String successPage() {
        return "success";
    }
}