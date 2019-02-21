package lk.eDoc.repository;

import lk.eDoc.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient,String> {
   @Query(value = "SELECT COUNT(PID) FROM Patient" ,nativeQuery = true)

   String getLastID();


}
