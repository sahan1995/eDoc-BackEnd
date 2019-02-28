package lk.eDoc.service.impl;

import lk.eDoc.entity.PatientFamDoc_PK;
import lk.eDoc.repository.PatientFamDocRepository;
import lk.eDoc.service.PatientFamDocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Transactional
@Service

public class PatientFamDocServiceImpl implements PatientFamDocService {

    @Autowired
    PatientFamDocRepository patientFamDocRepository;

    @Override
    public boolean ifFamDoc(String PID,String DID) {

        return patientFamDocRepository.findById(new PatientFamDoc_PK(PID,DID)).isPresent();
    }
}
