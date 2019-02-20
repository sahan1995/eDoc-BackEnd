package lk.eDoc.repository;

import lk.eDoc.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient,String> {
    @Query(name = Patient.query)
//    Methana Pageable danne Limit kyna keyword eka JPA Query wala use krnna denne nethi nisa
    List<Patient> getLastID(org.springframework.data.domain.Pageable pageable);


}
