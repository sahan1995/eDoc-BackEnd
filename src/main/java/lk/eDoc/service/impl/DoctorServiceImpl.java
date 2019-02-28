package lk.eDoc.service.impl;

import lk.eDoc.dto.*;
import lk.eDoc.entity.Appointment;
import lk.eDoc.entity.Doctor;
import lk.eDoc.entity.DoctorTel;
import lk.eDoc.entity.Patient;
import lk.eDoc.repository.AppointmentRepository;
import lk.eDoc.repository.DoctorRepository;
import lk.eDoc.repository.UserRepository;
import lk.eDoc.service.AppointmentService;
import lk.eDoc.service.DoctorService;
import lk.eDoc.service.UserService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
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
public class DoctorServiceImpl implements DoctorService {


    @Autowired
    DoctorRepository docRep;

    @Autowired
    UserService userService;

    @Autowired
    AppointmentRepository appointmentRepository;

    @Override
    public List<DoctorDTO> getAllDoctors() {

        List<DoctorDTO> doctorDTOS = new ArrayList<>();


        List<Doctor> allDocs = docRep.findAll();

        allDocs.forEach(doctor -> {

            DoctorDTO doctorDTO = new DoctorDTO();
            BeanUtils.copyProperties(doctor,doctorDTO);
            doctorDTOS.add(doctorDTO);


        });


        return doctorDTOS;
    }

    @Override
    public DoctorDTO findById(String DID) {

        Optional<Doctor> doctorById = docRep.findById(DID);
        ArrayList<DoctorTelDTO> doctorTelDTOS = new ArrayList<>();
        Doctor doctor = doctorById.get();
        List<DoctorTel> doctorTels = doctor.getDoctorTels();



        DoctorDTO doctorDTO = new DoctorDTO(doctor.getDID(), doctor.getFname(), doctor.getMname(), doctor.getLname(), doctor.getGender(), doctor.getDob()
                , doctor.getNIC(), doctor.getCountry(), doctor.getCity(), doctor.getLane(), doctor.getCode(), doctor.getLat(), doctor.getLng(), doctor.getProfilePic(), doctor.getUniversity(), doctor.getDegree()
                , doctor.getSpecilizedIn(), doctor.getHostipal(), doctor.getGovDID(), doctor.getWebFee(), doctor.getPpFee(), doctor.getToHomeFee(), doctor.getAboutMe());

        doctorTels.forEach(doctorTel -> {
            doctorTelDTOS.add(new DoctorTelDTO(doctorTel.getTel()));

        });
        System.out.println(doctorTelDTOS);
        doctorDTO.setDoctorTelDTOS(doctorTelDTOS);
        return doctorDTO;

    }

    @Override
    public void saveDoctor(String DID, @RequestBody DoctorDTO doctor) {

        if (!DID.equals(doctor.getDID())) {
            throw new RuntimeException(" Not Same ");
        }

        UserDTO userDTO = new UserDTO(doctor.getUname(), doctor.getPassword(), doctor.getRole(), DID);
        List<DoctorTel> doctorTels = new ArrayList<>();
        Doctor doctorSave = new Doctor(doctor.getDID(), doctor.getFname(), doctor.getMname(), doctor.getLname(), doctor.getGender(), doctor.getDob()
                , doctor.getIdenty(), doctor.getCountry(), doctor.getCity(), doctor.getLane(), doctor.getCode(), doctor.getLat(), doctor.getLng(), doctor.getProfilePic(), doctor.getUniversity(), doctor.getDegree()
                , doctor.getSpecilizedIn(), doctor.getHostipal(), doctor.getGovDID(), doctor.getWebFee(), doctor.getPpFee(), doctor.getToHomeFee(),doctor.getAboutMe());


        docRep.save(doctorSave);
        userService.saveUser(doctor.getUname(),userDTO);
        doctor.getDoctorTelDTOS().forEach(doctorTelDTO -> {
            doctorTels.add(new DoctorTel(doctorSave, doctorTelDTO.getTel()));
        });
        doctorSave.setDoctorTels(doctorTels);

    }

    @Override
    public void updateDoctor(String DID, @RequestBody DoctorDTO doctor) {
        if (!DID.equals(doctor.getDID())) {
            throw new RuntimeException(" ID Not Same");
        }

        List<DoctorTel> doctorTels = new ArrayList<>();
        Doctor doctorSave = new Doctor(doctor.getDID(), doctor.getFname(), doctor.getMname(), doctor.getLname(), doctor.getGender(), doctor.getDob()
                , doctor.getIdenty(), doctor.getCountry(), doctor.getCity(), doctor.getLane(), doctor.getCode(), doctor.getLat(), doctor.getLng(), doctor.getProfilePic(), doctor.getUniversity(), doctor.getDegree()
                , doctor.getSpecilizedIn(), doctor.getHostipal(), doctor.getGovDID(), doctor.getWebFee(), doctor.getPpFee(), doctor.getToHomeFee(),doctor.getAboutMe());


        docRep.save(doctorSave);

        doctor.getDoctorTelDTOS().forEach(doctorTelDTO -> {
            doctorTels.add(new DoctorTel(doctorSave, doctorTelDTO.getTel()));
        });
        doctorSave.setDoctorTels(doctorTels);
    }

    @Override
    public void deleteDoctor(String DID) {

        docRep.deleteById(DID);

    }

    @Override
    public String getLastID() {

        String lastID1 = docRep.getLastID();
        if(lastID1.equals("")){
            return null;
        }
        return lastID1;
    }

    @Override
    public boolean saveImage(MultipartFile proImage) throws IOException, URISyntaxException {

        String projectPath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getAbsolutePath();
        File uploadDir = new File(projectPath + "/uploads");
        uploadDir.mkdir();
        proImage.transferTo(new File(uploadDir.getAbsolutePath() + "/" + proImage.getOriginalFilename()));
        return true;
    }

    @Override
    public byte[] getProfilePic(String imgName) throws URISyntaxException, IOException {

        String projectPath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getAbsolutePath();
        File file = new File(projectPath + "/uploads/" + imgName);
        FileInputStream fileInputStream = new FileInputStream(file);

        String mimeType= URLConnection.guessContentTypeFromName(file.getName());
        System.out.println(mimeType);

        byte[] bytes = IOUtils.toByteArray(fileInputStream);
        return bytes;

    }

    @Override
    public List<AppointmentDTO> doctorAppointment(String DID) {

        List<Appointment> appointments = appointmentRepository.doctorAppointments(DID, 0,0);
        List<AppointmentDTO> appointmentDTOS = new ArrayList<>();
        appointments.forEach(appointment -> {

            AppointmentDTO appointmentDTO = new AppointmentDTO(appointment.getAppCode(), appointment.getTime(), appointment.getDate(), appointment.getAppType(), appointment.isCheck());
//            Doctor doctor = appointment.getDoctor();
            Patient patient = appointment.getPatient();
//            appointmentDTO.setDoctorDTO(new DoctorDTO(doctor.getDID(), doctor.getFname(), doctor.getMname(), doctor.getLname(), doctor.getGender(), doctor.getDob()
//                    , doctor.getNIC(), doctor.getCountry(), doctor.getCity(), doctor.getLane(), doctor.getCode(), doctor.getLat(), doctor.getLng(), doctor.getProfilePic(), doctor.getUniversity(), doctor.getDegree()
//                    , doctor.getSpecilizedIn(), doctor.getHostipal(), doctor.getGovDID(), doctor.getWebFee(), doctor.getPpFee(), doctor.getToHomeFee(),doctor.getAboutMe()));

            appointmentDTO.setPatientDTO(new PatientDTO(patient.getPID(), patient.getFname(), patient.getMname(),
                    patient.getLname(), patient.getGender(), patient.getDob(), patient.getNIC(),
                    patient.getCountry(), patient.getCity(), patient.getLane(), patient.getCode(), patient.getLat(),
                    patient.getLng(), patient.getProfilePic()));

            appointmentDTOS.add(appointmentDTO);
        });


        return appointmentDTOS;

    }

    @Override
    public void updateVideoKey(String DID, String Key) {
        docRep.updateVideoKey(DID,Key);
    }

    @Override
    public String getVideoKey(String DID) {
        return docRep.getVideoKey(DID);
    }

    @Override
    public List<DoctorDTO> getDoctorsBySpecilizedIn(String sepecial) {
        List<DoctorDTO> doctorDTOS = new ArrayList<>();
        List<Doctor> doctors = docRep.getDoctorsBySpecilizedIn(sepecial);


        doctors.forEach(doctor -> {
            DoctorDTO doctorDTO = new DoctorDTO();
            BeanUtils.copyProperties(doctor,doctorDTO);
            doctorDTOS.add(doctorDTO);
        });

        return doctorDTOS;
    }

    @Override
    public List<DoctorDTO> getDoctors(String param) {

        List<DoctorDTO> doctorDTOS = new ArrayList<>();
        List<Doctor> doctorsByName = docRep.getDoctorsByName(param);
        List<Doctor> doctorsHospital = docRep.getDoctorsHospital(param);
        List<Doctor> doctorsBySpecilizedIn = docRep.getDoctorsSpecial(param);
        if(!doctorsByName.isEmpty()){

            doctorsByName.forEach(doctor -> {
                DoctorDTO doctorDTO = new DoctorDTO();
                BeanUtils.copyProperties(doctor,doctorDTO);
                doctorDTOS.add(doctorDTO);
            });

        }else if(!doctorsHospital.isEmpty()){

            doctorsHospital.forEach(doctor -> {
                DoctorDTO doctorDTO = new DoctorDTO();
                BeanUtils.copyProperties(doctor,doctorDTO);
                doctorDTOS.add(doctorDTO);
            });
        }else if(!doctorsBySpecilizedIn.isEmpty()){
            doctorsBySpecilizedIn.forEach(doctor -> {
                DoctorDTO doctorDTO = new DoctorDTO();
                BeanUtils.copyProperties(doctor,doctorDTO);
                doctorDTOS.add(doctorDTO);
            });
        }

        return doctorDTOS;

        
    }


}