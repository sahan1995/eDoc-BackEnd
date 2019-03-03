package lk.eDoc.service.impl;

import lk.eDoc.entity.PatientFamDoc;
import lk.eDoc.entity.PatientFamDoc_PK;
import lk.eDoc.repository.DoctorRepository;
import lk.eDoc.repository.PatientFamDocRepository;
import lk.eDoc.repository.PatientRepository;
import lk.eDoc.service.PatientFamDocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
}
