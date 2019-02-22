package lk.eDoc.service.impl;

import lk.eDoc.dto.AppointmentDTO;
import lk.eDoc.dto.MedicalReportDTO;
import lk.eDoc.entity.MedicalReport;
import lk.eDoc.repository.MedicalReportRepository;
import lk.eDoc.service.MedicalReportService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class MedicalReportServiceImpl implements MedicalReportService {

    @Autowired
    MedicalReportRepository medicalReportRepository;

    @Override
    public void addMedicalReport(MedicalReportDTO medicalReportDTO) {

        MedicalReport medicalReport = new MedicalReport();
        BeanUtils.copyProperties(medicalReportDTO, medicalReport);
        medicalReportRepository.save(medicalReport);

    }

    @Override
    public List<MedicalReportDTO> getAll() {
        ArrayList<MedicalReportDTO> medicalReportDTOS = new ArrayList<>();

        medicalReportRepository.findAll().forEach(medicalReport -> {
            MedicalReportDTO medicalReportDTO = new MedicalReportDTO();
            BeanUtils.copyProperties(medicalReport,medicalReportDTO);
            medicalReportDTOS.add(medicalReportDTO);

        });

        return medicalReportDTOS;




    }
}
