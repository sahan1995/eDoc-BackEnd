package lk.eDoc.service;

import lk.eDoc.dto.DoctorRequestFamDocDTO;

import java.util.List;

public interface DoctorRequsetFamDocService {

    boolean sendRequest(String PID,String DID);

    boolean isSendRequest(String PID,String DID);

    boolean deleteRequest(String PID,String DID);

    List<DoctorRequestFamDocDTO> findDoctorRequest(String DID);

    void updateIsAccept(String PID,String DID);

    boolean removeDoctor(String PID,String DID);
}
