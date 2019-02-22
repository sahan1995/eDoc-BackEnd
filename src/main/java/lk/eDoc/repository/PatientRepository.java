package lk.eDoc.repository;

import lk.eDoc.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient,String> {
   @Query(value = "SELECT COUNT(PID) FROM Patient" ,nativeQuery = true)
   String getLastID();


   @Modifying
   @Query(value = "UPDATE Patient  SET videoCallID=:videoCallID WHERE PID =:PID",nativeQuery = true)
   void updateVideoKey(@Param("PID") String PID, @Param("videoCallID") String Key);

   @Query(value = "SELECT videoCallID FROM Patient d WHERE d.PID=:PID",nativeQuery = true)
   String getVideoKey(@Param("PID") String PID);
}
