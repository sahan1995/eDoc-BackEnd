package lk.eDoc.repository;

import lk.eDoc.entity.MedicalReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalReportRepository extends JpaRepository<MedicalReport,String> {


}
