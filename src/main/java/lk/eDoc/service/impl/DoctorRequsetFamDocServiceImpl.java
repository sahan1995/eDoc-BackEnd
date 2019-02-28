package lk.eDoc.service.impl;

import lk.eDoc.entity.DoctorRequestForFamDoc;
import lk.eDoc.entity.DoctorRequestForFamDoc_PK;
import lk.eDoc.repository.DoctorRepository;
import lk.eDoc.repository.DoctorRequsetFamDocRepository;
import lk.eDoc.repository.PatientRepository;
import lk.eDoc.service.DoctorRequsetFamDocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class DoctorRequsetFamDocServiceImpl implements DoctorRequsetFamDocService {


    @Autowired
    private DoctorRequsetFamDocRepository doctorRequsetFamDocRepository;

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    DoctorRepository doctorRepository;
    @Override
    public boolean sendRequest(String PID, String DID) {

        doctorRequsetFamDocRepository.save(new DoctorRequestForFamDoc(new DoctorRequestForFamDoc_PK(PID,DID),false,patientRepository.findById(PID).get(),doctorRepository.findById(DID).get()));
        return true;
    }

    @Override
    public boolean isSendRequest(String PID, String DID) {
        return doctorRequsetFamDocRepository.findById(new DoctorRequestForFamDoc_PK(PID,DID)).isPresent();
    }

    @Override
    public boolean deleteRequest(String PID, String DID) {
        doctorRequsetFamDocRepository.deleteById(new DoctorRequestForFamDoc_PK(PID,DID));
        return true;
    }
}
