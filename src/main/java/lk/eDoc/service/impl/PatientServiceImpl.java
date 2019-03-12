package lk.eDoc.service.impl;

import lk.eDoc.dto.*;
import lk.eDoc.entity.*;
import lk.eDoc.repository.AppointmentRepository;
import lk.eDoc.repository.DrugRepository;
import lk.eDoc.repository.PatientRepository;
import lk.eDoc.service.AppointmentService;
import lk.eDoc.service.PatientService;
import lk.eDoc.service.UserService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PatientServiceImpl implements PatientService {


    @Autowired
    PatientRepository patientRepository;

    @Autowired
    UserService userService;
    @Autowired
    AppointmentRepository appointmentRepository;


    @Override
    public List<PatientDTO> getAllPatient() {

        List<PatientDTO> patientDTOS  = new ArrayList<>();
        List<Patient> allPatients = patientRepository.findAll();


        allPatients.forEach(patient -> {

            patientDTOS.add(new PatientDTO(patient.getPID(),patient.getFname(),patient.getMname(),patient.getLname(),
                    patient.getGender(),patient.getDob(),patient.getNIC(),patient.getCountry(),patient.getCity(),patient.getLane(),
                    patient.getCode(),patient.getLat(),patient.getLng(),patient.getProfilePic(),patient.getEmail()
            ));
        });
            return patientDTOS;

    }

    @Override
    public PatientDTO findByID(String PID) {
        Optional<Patient> byId =
                patientRepository.findById(PID);
        Patient patient = byId.get();

        return new PatientDTO(patient.getPID(), patient.getFname(), patient.getMname(),
                patient.getLname(), patient.getGender(), patient.getDob(), patient.getNIC(),
                patient.getCountry(), patient.getCity(), patient.getLane(), patient.getCode(), patient.getLat(),
                patient.getLng(), patient.getProfilePic(),patient.getEmail());
    }

    @Override
    public void savePatient(String PID,PatientDTO patientDTO) {

        if(!PID.equals(patientDTO.getPID())){
            throw  new RuntimeException("ID Not Same");
        }
        UserDTO userDTO = new UserDTO(patientDTO.getUname(), patientDTO.getPassword(), patientDTO.getRole(), patientDTO.getPID());

        List<PatientTelDTO> patientTelDTOList = patientDTO.getPatientTelDTOList();

        List<PatientTel> patientTels  = new ArrayList<>();

        Patient patient = new Patient(patientDTO.getPID(), patientDTO.getFname(), patientDTO.getMname(),
                patientDTO.getLname(), patientDTO.getGender(), patientDTO.getDob(), patientDTO.getIdenty(),
                patientDTO.getCountry(), patientDTO.getCity(), patientDTO.getLane(), patientDTO.getCode(), patientDTO.getLat(),
                patientDTO.getLng(), patientDTO.getProfilePic(),patientDTO.getEmail());


        for (PatientTelDTO patientTel : patientTelDTOList) {
            patientTels.add(new PatientTel(patient,patientTel.getTel()));
        }
        userService.saveUser(userDTO.getUname(),userDTO);

        patientRepository.save(patient);
        patient.setPatientTels(patientTels);

    }

    @Override
    public void updatePatient(String PID, PatientDTO patientDTO) {

        if(!PID.equals(patientDTO.getPID())){
            throw new RuntimeException("IDs Not Same");
        }
        List<PatientTelDTO> patientTelDTOList = patientDTO.getPatientTelDTOList();
        List<PatientTel> patientTels  = new ArrayList<>();
        Patient patient = new Patient(patientDTO.getPID(), patientDTO.getFname(), patientDTO.getMname(),
                patientDTO.getLname(), patientDTO.getGender(), patientDTO.getDob(), patientDTO.getIdenty(),
                patientDTO.getCountry(), patientDTO.getCity(), patientDTO.getLane(), patientDTO.getCode(), patientDTO.getLat(),
                patientDTO.getLng(), patientDTO.getProfilePic(),patientDTO.getEmail());
        for (PatientTelDTO patientTel : patientTelDTOList) {
            patientTels.add(new PatientTel(patient,patientTel.getTel()));
        }
        patientRepository.save(patient);

        patient.setPatientTels(patientTels);
    }

    @Override
    public void deletePatient(String PID) {
        patientRepository.deleteById(PID);
        System.out.println("This Delete");
    }

    @Override
    public boolean saveProfileImage(MultipartFile image) throws Exception {
        String projectPath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getAbsolutePath();
        File uploadDir = new File(projectPath + "/uploads");
        uploadDir.mkdir();
        image.transferTo(new File(uploadDir.getAbsolutePath()+"/"+image.getOriginalFilename()));
        return true;

    }

    @Override
    public String getLastID() {

        String lastID1 = patientRepository.getLastID();

        if(lastID1.equals("")){
            return null;
        }
        return lastID1;
    }

    @Override
    public byte[] getProfilePicture(String picName) throws IOException, URISyntaxException {

        String projectPath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getAbsolutePath();
        File file = new File(projectPath + "/uploads/" + picName);
        FileInputStream fileInputStream = new FileInputStream(file);

        String mimeType= URLConnection.guessContentTypeFromName(file.getName());
        System.out.println(mimeType);

        byte[] bytes = IOUtils.toByteArray(fileInputStream);
        return bytes;

    }

    @Override
    public void updateVideoKey(String PID, String Key) {
        patientRepository.updateVideoKey(PID, Key);
    }

    @Override
    public String getVideoKey(String PID) {
        return patientRepository.getVideoKey(PID);
    }

    @Override
    public List<AppointmentDTO> patientAppointments(String PID) {



        List<Appointment> appointments = appointmentRepository.patientAppointments(PID, 0, 0);
        if(appointments==null){
            return null;
        }
        List<AppointmentDTO> appointmentDTOS = new ArrayList<>();
        appointments.forEach(appointment -> {
            DoctorDTO doctorDTO = new DoctorDTO();
            AppointmentDTO appointmentDTO = new AppointmentDTO(appointment.getAppCode(), appointment.getTime(), appointment.getDate(), appointment.getAppType(), appointment.isCheck());
            BeanUtils.copyProperties(appointment.getDoctor(),doctorDTO);
            appointmentDTO.setDoctorDTO(doctorDTO);
            appointmentDTOS.add(appointmentDTO);

        });

        return appointmentDTOS;
    }

    @Override
    public List<AppointmentDTO> getAppointmentbyType(String PID, String appType) {

        List<Appointment> byTypePatient = appointmentRepository.getByTypePatient(appType, PID, 0, 0);
        if(byTypePatient==null){
            return null;
        }
        List<AppointmentDTO> appointmentDTOS = new ArrayList<>();

        byTypePatient.forEach(appointment -> {
            DoctorDTO doctorDTO = new DoctorDTO();
            AppointmentDTO appointmentDTO = new AppointmentDTO(appointment.getAppCode(), appointment.getTime(), appointment.getDate(), appointment.getAppType(), appointment.isCheck());
            BeanUtils.copyProperties(appointment.getDoctor(),doctorDTO);
            appointmentDTO.setDoctorDTO(doctorDTO);
            appointmentDTOS.add(appointmentDTO);
        });
        return appointmentDTOS;
    }

    @Override
    public List<AppointmentDTO> getFinishedAppointments(String PID) {
        List<Appointment> finishedAppointments = appointmentRepository.getFinishedAppointments(PID, true);
        if(finishedAppointments.isEmpty()){
            return null;
        }
        List<AppointmentDTO> appointmentDTOS = new ArrayList<>();

        finishedAppointments.forEach(appointment -> {
            AppointmentDTO appointmentDTO = new AppointmentDTO();
            DoctorDTO doctorDTO = new DoctorDTO();
            PrescriptionDTO prescriptionDTO = new PrescriptionDTO();
            List<DrugDTO> drugDTOS = new ArrayList<>();
            BeanUtils.copyProperties(appointment,appointmentDTO);
            BeanUtils.copyProperties(appointment.getDoctor(),doctorDTO);
            BeanUtils.copyProperties(appointment.getPrescription(),prescriptionDTO);


            appointment.getPrescription().getDrugs().forEach(drug -> {

                System.out.println(drug.getDrug()+" "+appointment.getAppCode());

                DrugDTO drugDTO = new DrugDTO();
                BeanUtils.copyProperties(drug,drugDTO);
                drugDTOS.add(drugDTO);

            });


            prescriptionDTO.setDrugs(drugDTOS);
            appointmentDTO.setPrescriptionDTO(prescriptionDTO);
            appointmentDTO.setDoctorDTO(doctorDTO);
            appointmentDTOS.add(appointmentDTO);
        });

        return appointmentDTOS;

    }
}
