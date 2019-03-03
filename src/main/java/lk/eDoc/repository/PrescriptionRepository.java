package lk.eDoc.repository;

import lk.eDoc.entity.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PrescriptionRepository extends JpaRepository<Prescription,String> {


    @Query(value = "SELECT COUNT(prescriptionID) FROM Prescription", nativeQuery = true)
    String getLastId();

    @Query(value ="SELECT * FROM Prescription WHERE appCode=:appCode" ,nativeQuery = true)
    Prescription getPrescription(@Param("appCode") String appCode);

}
