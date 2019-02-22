package lk.eDoc.service;

import lk.eDoc.dto.AppointmentDTO;
import lk.eDoc.dto.PatientDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public interface PatientService  {

    List<PatientDTO> getAllPatient();

    PatientDTO findByID(String PID);

    void savePatient(String PID, PatientDTO patient);

    void updatePatient(String PID, PatientDTO patient);

    void deletePatient(String PID);

    boolean saveProfileImage(MultipartFile image) throws Exception;

    String getLastID();

    byte [] getProfilePicture(String picName) throws IOException, URISyntaxException;

    void updateVideoKey(String PID, String Key);

    String getVideoKey(String PID);

    List<AppointmentDTO> patientAppointments(String PID);

    List<AppointmentDTO> getAppointmentbyType(String PID,String appType);
}
