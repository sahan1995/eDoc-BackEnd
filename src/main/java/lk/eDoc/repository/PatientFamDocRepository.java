package lk.eDoc.repository;

import lk.eDoc.entity.PatientFamDoc;
import lk.eDoc.entity.PatientFamDoc_PK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientFamDocRepository extends JpaRepository<PatientFamDoc, PatientFamDoc_PK> {


}
