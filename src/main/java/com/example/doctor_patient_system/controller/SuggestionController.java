package com.example.doctorpatientsystem.controller;

import com.example.doctorpatientsystem.entity.Doctor;
import com.example.doctorpatientsystem.entity.Patient;
import com.example.doctorpatientsystem.service.DoctorService;
import com.example.doctorpatientsystem.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/suggestions")
public class SuggestionController {
    @Autowired
    private DoctorService doctorService;

    @Autowired
    private PatientService patientService;

    @GetMapping("/{patientId}")
    public ResponseEntity<Object> suggestDoctors(@PathVariable Long patientId) {
        Patient patient = patientService.getPatient(patientId);
        List<Doctor> suggestedDoctors = doctorService.suggestDoctors(patient);

        if (suggestedDoctors.isEmpty()) {
            if (!patient.getCity().equalsIgnoreCase("DELHI") && 
                !patient.getCity().equalsIgnoreCase("NOIDA") && 
                !patient.getCity().equalsIgnoreCase("FARIDABAD")) {
                return ResponseEntity.ok("We are still waiting to expand to your location");
            } else {
                return ResponseEntity.ok("There isn't any doctor present at your location for your symptom");
            }
        }

        return ResponseEntity.ok(suggestedDoctors);
    }
}