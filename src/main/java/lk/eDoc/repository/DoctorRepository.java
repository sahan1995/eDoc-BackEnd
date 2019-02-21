package lk.eDoc.repository;

import lk.eDoc.entity.Appointment;
import lk.eDoc.entity.Doctor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor,String> {

    @Query(value = "SELECT count(DID) FROM Doctor",nativeQuery = true)
    String getLastID();



}
