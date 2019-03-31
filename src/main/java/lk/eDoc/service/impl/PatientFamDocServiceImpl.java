package lk.eDoc.service.impl;

import lk.eDoc.dto.DoctorDTO;
import lk.eDoc.dto.PatientDTO;
import lk.eDoc.dto.PatientFamDocDTO;
import lk.eDoc.entity.PatientFamDoc;
import lk.eDoc.entity.PatientFamDoc_PK;
import lk.eDoc.repository.DoctorRepository;
import lk.eDoc.repository.PatientFamDocRepository;
import lk.eDoc.repository.PatientRepository;
import lk.eDoc.service.PatientFamDocService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service

public class PatientFamDocServiceImpl implements PatientFamDocService {

    @Autowired
    PatientFamDocRepository patientFamDocRepository;

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    DoctorRepository doctorRepository;
    @Override
    public boolean ifFamDoc(String PID,String DID) {

        return patientFamDocRepository.findById(new PatientFamDoc_PK(PID,DID)).isPresent();
    }

    @Override
    public boolean addPatient(String PID, String DID) {
        patientFamDocRepository.save(new PatientFamDoc(PID,DID,patientRepository.findById(PID).get(),doctorRepository.findById(DID).get()));
        return true;
    }

    @Override
    public boolean removeDoctor(String PID, String DID) {
        patientFamDocRepository.deleteById(new PatientFamDoc_PK(PID,DID));
        return  true;
    }

    @Override
    public List<PatientFamDocDTO> getPatientFamDoc(String PID) {

        List<PatientFamDoc> patientFamDoc = patientFamDocRepository.getPatientFamDoc(PID);
        List<PatientFamDocDTO> patientFamDocDTOS = new ArrayList<>();
        if(!patientFamDoc.isEmpty()){


            patientFamDoc.forEach(famdoc->{
//                PatientDTO patientDTO = new PatientDTO();
                DoctorDTO doctorDTO = new DoctorDTO();
                BeanUtils.copyProperties(famdoc.getDoctor(),doctorDTO);
//                BeanUtils.copyProperties(famdoc.getPatient(),patientDTO);
                patientFamDocDTOS.add(new PatientFamDocDTO(null,doctorDTO));
            });
        }
        return patientFamDocDTOS;
    }

    @Override
    public List<PatientFamDocDTO> getDoctorsPatients(String DID) {
        List<PatientFamDoc> doctorsPatients = patientFamDocRepository.getDoctorsPatients(DID);
        List<PatientFamDocDTO> patientFamDocDTOS = new ArrayList<>();
        if(!doctorsPatients.isEmpty()){
            doctorsPatients.forEach(patients->{
                PatientDTO patientDTO = new PatientDTO();
//                DoctorDTO doctorDTO = new DoctorDTO();
                BeanUtils.copyProperties(patients.getPatient(),patientDTO);
//                BeanUtils.copyProperties(patients.getDoctor(),doctorDTO);
                patientFamDocDTOS.add(new PatientFamDocDTO(patientDTO,null));
            });
        }
        return patientFamDocDTOS;
    }
}
