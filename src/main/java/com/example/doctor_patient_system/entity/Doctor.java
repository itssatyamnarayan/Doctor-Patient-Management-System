package com.example.doctorpatientsystem.entity;

import com.example.doctorpatientsystem.enums.City;
import com.example.doctorpatientsystem.enums.Speciality;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 3)
    private String name;

    @NotNull
    @Enumerated(EnumType.STRING)
    private City city;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(min = 10)
    private String phoneNumber;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Speciality speciality;

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }
}