package lk.eDoc.repository;

import lk.eDoc.entity.PatientFamDoc;
import lk.eDoc.entity.PatientFamDoc_PK;
import org.aspectj.lang.annotation.Around;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PatientFamDocRepository extends JpaRepository<PatientFamDoc, PatientFamDoc_PK> {

    @Query(value = "SELECT * FROM PatientFamDoc WHERE PID=:PID",nativeQuery = true)
    List<PatientFamDoc> getPatientFamDoc(@Param("PID") String PID);
}
