package com.example.doctorpatientsystem.repository;

import com.example.doctorpatientsystem.entity.Doctor;
import com.example.doctorpatientsystem.enums.City;
import com.example.doctorpatientsystem.enums.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    List<Doctor> findByCityAndSpeciality(City city, Speciality speciality);
}