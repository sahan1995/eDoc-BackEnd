package lk.eDoc.repository;

import lk.eDoc.entity.Doctor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor,String> {
    @Query(name = Doctor.query)
    List<Doctor>getLastID(Pageable pageable);




}
