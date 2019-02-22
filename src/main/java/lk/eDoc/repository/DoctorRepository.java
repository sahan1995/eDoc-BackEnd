package lk.eDoc.repository;

import lk.eDoc.entity.Appointment;
import lk.eDoc.entity.Doctor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor,String> {

    @Query(value = "SELECT count(DID) FROM Doctor",nativeQuery = true)
    String getLastID();

    @Modifying
    @Query(value = "UPDATE Doctor  SET videoCallID=:videoCallID WHERE DID =:DID",nativeQuery = true)
    void updateVideoKey(@Param("DID") String DID,@Param("videoCallID") String Key);

    @Query(value = "SELECT videoCallID FROM Doctor d WHERE d.DID=:DID",nativeQuery = true)
    String getVideoKey(@Param("DID") String DID);

}
