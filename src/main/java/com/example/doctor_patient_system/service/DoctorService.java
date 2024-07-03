package com.example.doctorpatientsystem.service;

import com.example.doctorpatientsystem.entity.Doctor;
import com.example.doctorpatientsystem.entity.Patient;
import com.example.doctorpatientsystem.enums.City;
import com.example.doctorpatientsystem.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    public Doctor addDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public void removeDoctor(Long id) {
        doctorRepository.deleteById(id);
    }

    public List<Doctor> suggestDoctors(Patient patient) {
        City patientCity;
        try {
            patientCity = City.valueOf(patient.getCity().toUpperCase());
        } catch (IllegalArgumentException e) {
            return Collections.emptyList();
        }

        return doctorRepository.findByCityAndSpeciality(patientCity, patient.getSymptom().getSpeciality());
    }
}