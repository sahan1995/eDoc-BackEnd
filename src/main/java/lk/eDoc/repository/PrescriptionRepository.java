package lk.eDoc.repository;

import lk.eDoc.entity.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PrescriptionRepository extends JpaRepository<Prescription,String> {


    @Query(value = "SELECT COUNT(prescriptionID) FROM Prescription", nativeQuery = true)
    String getLastId();

}
