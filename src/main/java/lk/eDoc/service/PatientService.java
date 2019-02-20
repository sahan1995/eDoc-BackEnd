package lk.eDoc.service;

import lk.eDoc.dto.PatientDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface PatientService  {

    List<PatientDTO> getAllPatient();

    PatientDTO findByID(String PID);

    void savePatient(String PID, PatientDTO patient);

    void updatePatient(String PID, PatientDTO patient);

    void deletePatient(String PID);

    boolean saveProfileImage(MultipartFile image) throws Exception;

    String getLastID();

}
