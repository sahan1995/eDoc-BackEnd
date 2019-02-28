package lk.eDoc.repository;

import lk.eDoc.entity.DoctorRequestForFamDoc;
import lk.eDoc.entity.DoctorRequestForFamDoc_PK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRequsetFamDocRepository extends JpaRepository<DoctorRequestForFamDoc,DoctorRequestForFamDoc_PK> {
}
