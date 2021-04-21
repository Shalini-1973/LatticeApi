package com.lattice.assignment.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lattice.assignment.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {


}
