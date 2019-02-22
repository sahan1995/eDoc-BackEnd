package lk.eDoc.service;

import lk.eDoc.dto.AppointmentDTO;
import lk.eDoc.dto.MedicalReportDTO;
import lk.eDoc.entity.MedicalReport;

import java.util.List;

public interface MedicalReportService {

    void addMedicalReport(MedicalReportDTO medicalReportDTO);

        List<MedicalReportDTO> getAll();
}
