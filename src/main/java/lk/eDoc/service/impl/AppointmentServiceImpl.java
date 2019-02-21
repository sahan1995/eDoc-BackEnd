package lk.eDoc.service.impl;

import lk.eDoc.dto.AppointmentDTO;
import lk.eDoc.dto.DoctorDTO;
import lk.eDoc.dto.PatientDTO;
import lk.eDoc.entity.Appointment;
import lk.eDoc.entity.Doctor;
import lk.eDoc.entity.Patient;
import lk.eDoc.repository.AppointmentRepository;
import lk.eDoc.service.AppointmentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    AppointmentRepository appointmentRepo;

//    @Autowired
//    EntityManager entityManager;

    @Override
    public List<AppointmentDTO> getAllAppointment() {
        return null;
    }

    @Override
    public boolean addAppointment(String appCpde,AppointmentDTO app) {
        if(!appCpde.equals(app.getAppCode())){
            throw new RuntimeException("Codes are not Same");
        }
        Appointment appointment = new Appointment(app.getAppCode(), app.getTime(), app.getDate(), app.getAppType(), app.isCheck(),app.isCancle());

        PatientDTO patientDTO = app.getPatientDTO();

        appointment.setPatient(new Patient(patientDTO.getPID(), patientDTO.getFname(), patientDTO.getMname(),
                patientDTO.getLname(), patientDTO.getGender(), patientDTO.getDob(), patientDTO.getIdenty(),
                patientDTO.getCountry(), patientDTO.getCity(), patientDTO.getLane(), patientDTO.getCode(), patientDTO.getLat(),
                patientDTO.getLng(), patientDTO.getProfilePic()));

        DoctorDTO doctor = app.getDoctorDTO();

        appointment.setDoctor(new Doctor(doctor.getDID(), doctor.getFname(), doctor.getMname(), doctor.getLname(), doctor.getGender(), doctor.getDob()
                , doctor.getIdenty(), doctor.getCountry(), doctor.getCity(), doctor.getLane(), doctor.getCode(), doctor.getLat(), doctor.getLng(), doctor.getProfilePic(), doctor.getUniversity(), doctor.getDegree()
                , doctor.getSpecilizedIn(), doctor.getHostipal(), doctor.getGovDID(), doctor.getWebFee(), doctor.getPpFee(), doctor.getToHomeFee(),doctor.getAboutMe()));

        appointmentRepo.save(appointment);

        return true;
    }

    @Override
    public boolean checkAppointmentAvalable(String DID, String date, String time) {

        System.out.println(DID+" "+date+" "+time);
        String appointment = appointmentRepo.checkAppointmentAvalable(DID, date, time, 0,0);
        System.out.println(appointment);
        if(appointment!=null){
            System.out.println("Methana");
            return true;
        }
        return false;
    }

    @Override
    public String getLastID() {


        String lastID1 = appointmentRepo.getLastID();
        if(lastID1.equals("")){
            return null;
        }
        return lastID1;
    }

    @Override
    public AppointmentDTO findByID(String appCode) {

        Optional<Appointment> byId = appointmentRepo.findById(appCode);
        if(byId.isPresent()){
            Appointment appointment = byId.get();
            Patient patient = appointment.getPatient();
            Doctor doctor = appointment.getDoctor();

            PatientDTO patientDTO = new PatientDTO();
            DoctorDTO doctorDTO = new DoctorDTO();

            BeanUtils.copyProperties(patient,patientDTO);
            BeanUtils.copyProperties(doctor,doctorDTO);
            System.out.println(patient);
            AppointmentDTO appointmentDTO = new AppointmentDTO(appointment.getAppCode(), appointment.getTime(), appointment.getDate(), appointment.getAppType(), appointment.isCheck());
//            appointmentDTO.setPatientDTO(new PatientDTO(patient.getPID(), patient.getFname(), patient.getMname(),
//                    patient.getLname(), patient.getGender(), patient.getDob(), patient.getNIC(),
//                    patient.getCountry(), patient.getCity(), patient.getLane(), patient.getCode(), patient.getLat(),
//                    patient.getLng(), patient.getProfilePic()));

            appointmentDTO.setPatientDTO(patientDTO);
//            appointmentDTO.setDoctorDTO(new DoctorDTO(doctor.getDID(), doctor.getFname(), doctor.getMname(), doctor.getLname(), doctor.getGender(), doctor.getDob()
//                    , doctor.getNIC(), doctor.getCountry(), doctor.getCity(), doctor.getLane(), doctor.getCode(), doctor.getLat(), doctor.getLng(), doctor.getProfilePic(), doctor.getUniversity(), doctor.getDegree()
//                    , doctor.getSpecilizedIn(), doctor.getHostipal(), doctor.getGovDID(), doctor.getWebFee(), doctor.getPpFee(), doctor.getToHomeFee(),doctor.getAboutMe()));

            appointmentDTO.setDoctorDTO(doctorDTO);
            return appointmentDTO;
        }else{
            return null;
        }
    }

    @Override
    public List<AppointmentDTO> findByApptype(String appType, String DID) {

        List<Appointment> byType = appointmentRepo.getByType(appType, DID,0,0);
        List<AppointmentDTO> appointmentDTOS = new ArrayList<>();
        if(byType!=null){

            byType.forEach(appointment -> {
                PatientDTO patientDTO = new PatientDTO();
                DoctorDTO doctorDTO = new DoctorDTO();
                BeanUtils.copyProperties(appointment.getPatient(),patientDTO);
                BeanUtils.copyProperties(appointment.getDoctor(),doctorDTO);
                appointmentDTOS.add(new AppointmentDTO(appointment.getAppCode(),appointment.getTime(),appointment.getDate(),appointment.getAppType(),appointment.isCheck(),patientDTO,doctorDTO,appointment.isCancle()));

            });
            return appointmentDTOS;
        }

        return null;
    }

    @Override
    public List<AppointmentDTO> findByDate(String date, String DID) {
        List<Appointment> byDate = appointmentRepo.findByDate(date, DID, 0, 0);
        List<AppointmentDTO> appointmentDTOS = new ArrayList<>();
        if (byDate==null){
            return  null;
        }
        byDate.forEach(appointment -> {
            PatientDTO patientDTO = new PatientDTO();
            DoctorDTO doctorDTO = new DoctorDTO();
            BeanUtils.copyProperties(appointment.getPatient(),patientDTO);
            BeanUtils.copyProperties(appointment.getDoctor(),doctorDTO);
            appointmentDTOS.add(new AppointmentDTO(appointment.getAppCode(),appointment.getTime(),appointment.getDate(),appointment.getAppType(),appointment.isCheck(),patientDTO,doctorDTO,appointment.isCancle()));
        });
        return appointmentDTOS;
    }

    @Override
    public List<AppointmentDTO> findByDateAndType(String date, String DID, String appType) {

        List<Appointment> byDateAndType = appointmentRepo.findByDateAndType(date, DID, 0, 0, appType);
        List<AppointmentDTO> appointmentDTOS = new ArrayList<>();
        if(byDateAndType==null){
            return null;
        }
        byDateAndType.forEach(appointment -> {
            PatientDTO patientDTO = new PatientDTO();
            DoctorDTO doctorDTO = new DoctorDTO();
            BeanUtils.copyProperties(appointment.getPatient(),patientDTO);
            BeanUtils.copyProperties(appointment.getDoctor(),doctorDTO);
            appointmentDTOS.add(new AppointmentDTO(appointment.getAppCode(),appointment.getTime(),appointment.getDate(),appointment.getAppType(),appointment.isCheck(),patientDTO,doctorDTO,appointment.isCancle()));
        });

        return appointmentDTOS;
    }


}
