package lk.eDoc.service.impl;

import lk.eDoc.dto.DoctorRequestFamDocDTO;
import lk.eDoc.dto.PatientDTO;
import lk.eDoc.entity.DoctorRequestForFamDoc;
import lk.eDoc.entity.DoctorRequestForFamDoc_PK;
import lk.eDoc.repository.DoctorRepository;
import lk.eDoc.repository.DoctorRequsetFamDocRepository;
import lk.eDoc.repository.PatientRepository;
import lk.eDoc.service.DoctorRequsetFamDocService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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

        doctorRequsetFamDocRepository.save(new DoctorRequestForFamDoc(new DoctorRequestForFamDoc_PK(PID,DID),false,false,patientRepository.findById(PID).get(),doctorRepository.findById(DID).get()));
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

    @Override
    public List<DoctorRequestFamDocDTO> findDoctorRequest(String DID) {

        List<DoctorRequestForFamDoc> doctorRequest = doctorRequsetFamDocRepository.findDoctorRequest(DID, false);
        List<DoctorRequestFamDocDTO> doctorRequestFamDocDTOS = new ArrayList<>();
        doctorRequest.forEach(doctorRequestForFamDoc -> {
            PatientDTO patientDTO = new PatientDTO();
            DoctorRequestFamDocDTO doctorRequestFamDocDTO = new DoctorRequestFamDocDTO(doctorRequestForFamDoc.getDoctorRequestForFamDoc_pk().getPID(),
                    doctorRequestForFamDoc.getDoctorRequestForFamDoc_pk().getDID(),doctorRequestForFamDoc.isCancle(),doctorRequestForFamDoc.isCancle());
            BeanUtils.copyProperties(doctorRequestForFamDoc.getPatient(),patientDTO);
            doctorRequestFamDocDTO.setPatientDTO(patientDTO);
            doctorRequestFamDocDTOS.add(doctorRequestFamDocDTO);
        });

        return doctorRequestFamDocDTOS;
    }

    @Override
    public void updateIsAccept(String PID, String DID) {
        System.out.println(PID);

        System.out.println(DID);


        doctorRequsetFamDocRepository.updateIsAccept(true,DID,PID);
    }
}
