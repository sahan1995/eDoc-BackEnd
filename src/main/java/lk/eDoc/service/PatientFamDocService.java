package lk.eDoc.service;

import lk.eDoc.dto.PatientFamDocDTO;
import lk.eDoc.entity.PatientFamDoc_PK;

import java.util.List;

public interface PatientFamDocService {

    boolean ifFamDoc(String PID,String DID);

    boolean addPatient(String PID,String DID);

    boolean removeDoctor(String PID,String DID);

    List<PatientFamDocDTO> getPatientFamDoc(String PID);

    List<PatientFamDocDTO> getDoctorsPatients(String DID);
}
