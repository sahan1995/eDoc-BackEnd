package lk.eDoc.service;

import lk.eDoc.dto.AppointmentDTO;
import lk.eDoc.dto.DoctorDTO;
import lk.eDoc.entity.Appointment;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public interface DoctorService {

    List<DoctorDTO> getAllDoctors();

    DoctorDTO findById(String DID);

    void saveDoctor(String DID, DoctorDTO doctorDTO);

    void updateDoctor(String DID, DoctorDTO doctorDTO);

    void deleteDoctor(String DID);

    String getLastID();

    boolean saveImage(MultipartFile proImage) throws IOException,URISyntaxException;

    byte[] getProfilePic(String imgName) throws URISyntaxException, IOException;

    List<AppointmentDTO> doctorAppointment(String DID);
}
