package lk.eDoc.service;

import lk.eDoc.entity.PatientFamDoc_PK;

public interface PatientFamDocService {

    boolean ifFamDoc(String PID,String DID);

    boolean addPatient(String PID,String DID);

    boolean removeDoctor(String PID,String DID);

}
