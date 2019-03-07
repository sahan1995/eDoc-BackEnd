package lk.eDoc.service.impl;

import lk.eDoc.dto.DrugDTO;
import lk.eDoc.dto.PrescriptionDTO;
import lk.eDoc.entity.Drug;
import lk.eDoc.entity.Prescription;
import lk.eDoc.repository.AppointmentRepository;
import lk.eDoc.repository.PrescriptionRepository;
import lk.eDoc.service.PrescriptionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class PrescriptionServiceImpl implements PrescriptionService {

    @Autowired
    PrescriptionRepository prescriptionRepository;

    @Autowired
    AppointmentRepository appointmentRepository;
    @Override
    public boolean addPrescription(String prescID, String AppCode, PrescriptionDTO prescriptionDTO) {

        if(!prescID.equals(prescriptionDTO.getPrescriptionID())){
            throw new RuntimeException("ID not Same");
        }
        Prescription prescription = new Prescription();
        BeanUtils.copyProperties(prescriptionDTO,prescription);
        prescription.setAppointment(appointmentRepository.findById(AppCode).get());
        prescriptionRepository.save(prescription);
        return true;


    }

    @Override
    public String getLastId() {
        return prescriptionRepository.getLastId();
    }

    @Override
    public PrescriptionDTO getPrescription(String appCode) {
        Prescription prescription = prescriptionRepository.getPrescription(appCode);

        PrescriptionDTO prescriptionDTO = new PrescriptionDTO();

        BeanUtils.copyProperties(prescription,prescriptionDTO);

        List<Drug> drugs = prescription.getDrugs();

        List<DrugDTO> drugDTOS = new ArrayList<>();

        drugs.forEach(drug -> {

            DrugDTO drugDTO = new DrugDTO();

            BeanUtils.copyProperties(drug,drugDTO);
            drugDTOS.add(drugDTO);
        });

        prescriptionDTO.setDrugs(drugDTOS);

        return prescriptionDTO;
    }
}
