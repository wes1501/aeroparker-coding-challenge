package com.example.demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "customers")
public class Customer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime registered = LocalDateTime.now();

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    @Column(unique = true, nullable = false, length = 255)
    private String emailAddress;

    @NotBlank(message = "Title is required")
    @Size(max = 5, message = "Title must be up to 5 characters")
    @Column(nullable = false, length = 5)
    private String title;

    @NotBlank(message = "First name is required")
    @Size(max = 50)
    @Column(nullable = false, length = 50)
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Size(max = 50)
    @Column(nullable = false, length = 50)
    private String lastName;

    @NotBlank(message = "Address line 1 is required")
    @Size(max = 255)
    @Column(nullable = false, length = 255)
    private String addressLine1;

    @Size(max = 255)
    @Column(length = 255)
    private String addressLine2;

    @Size(max = 255)
    @Column(length = 255)
    private String city;

    @NotBlank(message = "Postcode is required")
    @Size(max = 10)
    @Column(nullable = false, length = 10)
    private String postcode;

    @Size(max = 20)
    @Column(length = 20)
    private String phoneNumber;


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public LocalDateTime getRegistered() { return registered; }
    public String getEmailAddress() { return emailAddress; }
    public void setEmailAddress(String emailAddress) { this.emailAddress = emailAddress.toLowerCase(); }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getAddressLine1() { return addressLine1; }
    public void setAddressLine1(String addressLine1) { this.addressLine1 = addressLine1; }
    public String getAddressLine2() { return addressLine2; }
    public void setAddressLine2(String addressLine2) { this.addressLine2 = addressLine2; }
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    public String getPostcode() { return postcode; }
    public void setPostcode(String postcode) { this.postcode = postcode; }
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
}