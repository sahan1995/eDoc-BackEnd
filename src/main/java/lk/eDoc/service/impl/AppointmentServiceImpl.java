package lk.eDoc.service.impl;

import lk.eDoc.dto.*;
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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    AppointmentRepository appointmentRepo;

    @Override
    public List<AppointmentDTO> getAllAppointment() {
        return null;
    }

    @Override
    public boolean addAppointment(String appCpde, AppointmentDTO app) {
        if (!appCpde.equals(app.getAppCode())) {
            throw new RuntimeException("Codes are not Same");
        }
        Appointment appointment = new Appointment(app.getAppCode(), app.getTime(), app.getDate(), app.getAppType(), app.isCheck(), app.isCancle());

        PatientDTO patientDTO = app.getPatientDTO();

        appointment.setPatient(new Patient(patientDTO.getPID(), patientDTO.getFname(), patientDTO.getMname(),
                patientDTO.getLname(), patientDTO.getGender(), patientDTO.getDob(), patientDTO.getIdenty(),
                patientDTO.getCountry(), patientDTO.getCity(), patientDTO.getLane(), patientDTO.getCode(), patientDTO.getLat(),
                patientDTO.getLng(), patientDTO.getProfilePic(),patientDTO.getEmail()));

        DoctorDTO doctor = app.getDoctorDTO();

        appointment.setDoctor(new Doctor(doctor.getDID(), doctor.getFname(), doctor.getMname(), doctor.getLname(), doctor.getGender(), doctor.getDob()
                , doctor.getIdenty(), doctor.getCountry(), doctor.getCity(), doctor.getLane(), doctor.getCode(), doctor.getLat(), doctor.getLng(), doctor.getProfilePic(), doctor.getUniversity(), doctor.getDegree()
                , doctor.getSpecilizedIn(), doctor.getHostipal(), doctor.getGovDID(), doctor.getWebFee(), doctor.getPpFee(), doctor.getToHomeFee(), doctor.getAboutMe(),doctor.getEmail()));

        appointmentRepo.save(appointment);

        return true;
    }

    @Override
    public boolean checkAppointmentAvalable(String DID, String date, String time) {

        System.out.println(DID + " " + date + " " + time);
        String appointment = appointmentRepo.checkAppointmentAvalable(DID, date, time, 0, 0);
        System.out.println(appointment);
        if (appointment != null) {
            System.out.println("Methana");
            return true;
        }
        return false;
    }

    @Override
    public String getLastID() {


        String lastID1 = appointmentRepo.getLastID();
        if (lastID1.equals("")) {
            return null;
        }
        return lastID1;
    }

    @Override
    public AppointmentDTO findByID(String appCode) {

        Optional<Appointment> byId = appointmentRepo.findById(appCode);
        if (byId.isPresent()) {
            Appointment appointment = byId.get();
            Patient patient = appointment.getPatient();
            Doctor doctor = appointment.getDoctor();
            List<Appointment> appointments = patient.getAppointments();


            PatientDTO patientDTO = new PatientDTO();
            DoctorDTO doctorDTO = new DoctorDTO();

            List<AppointmentDTO> appointmentDTOS = new ArrayList<>();
            appointments.forEach(app->{
                AppointmentDTO patientsAppointmets = new AppointmentDTO();
                PrescriptionDTO prescriptionDTO = new PrescriptionDTO();

//
//                BeanUtils.copyProperties(app.getPrescription(),prescriptionDTO);
                BeanUtils.copyProperties(app,patientsAppointmets);
//                patientsAppointmets.setPrescriptionDTO(prescriptionDTO);
                appointmentDTOS.add(patientsAppointmets);
            });



            BeanUtils.copyProperties(patient, patientDTO);
            BeanUtils.copyProperties(doctor, doctorDTO);
            System.out.println(patient);
            patientDTO.setAppointmentDTO(appointmentDTOS);
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
        } else {
            return null;
        }
    }

    @Override
    public List<AppointmentDTO> findByApptype(String appType, String DID) {

        List<Appointment> byType = appointmentRepo.getByType(appType, DID, 0, 0);
        List<AppointmentDTO> appointmentDTOS = new ArrayList<>();
        if (byType != null) {

            byType.forEach(appointment -> {
                PatientDTO patientDTO = new PatientDTO();
                DoctorDTO doctorDTO = new DoctorDTO();
                BeanUtils.copyProperties(appointment.getPatient(), patientDTO);
                BeanUtils.copyProperties(appointment.getDoctor(), doctorDTO);
                appointmentDTOS.add(new AppointmentDTO(appointment.getAppCode(), appointment.getTime(), appointment.getDate(), appointment.getAppType(), appointment.isCheck(), patientDTO, doctorDTO, appointment.isCancle()));

            });
            return appointmentDTOS;
        }

        return null;
    }

    @Override
    public List<AppointmentDTO> findByDate(String date, String DID) {
        List<Appointment> byDate = appointmentRepo.findByDate(date, DID, 0, 0);
        List<AppointmentDTO> appointmentDTOS = new ArrayList<>();
        if (byDate == null) {
            return null;
        }
        byDate.forEach(appointment -> {
            PatientDTO patientDTO = new PatientDTO();
            DoctorDTO doctorDTO = new DoctorDTO();
            BeanUtils.copyProperties(appointment.getPatient(), patientDTO);
            BeanUtils.copyProperties(appointment.getDoctor(), doctorDTO);
            appointmentDTOS.add(new AppointmentDTO(appointment.getAppCode(), appointment.getTime(), appointment.getDate(), appointment.getAppType(), appointment.isCheck(), patientDTO, doctorDTO, appointment.isCancle()));
        });
        return appointmentDTOS;
    }

    @Override
    public List<AppointmentDTO> findByDateAndType(String date, String DID, String appType) {

        List<Appointment> byDateAndType = appointmentRepo.findByDateAndType(date, DID, 0, 0, appType);
        List<AppointmentDTO> appointmentDTOS = new ArrayList<>();
        if (byDateAndType == null) {
            return null;
        }
        byDateAndType.forEach(appointment -> {
            PatientDTO patientDTO = new PatientDTO();
            DoctorDTO doctorDTO = new DoctorDTO();
            BeanUtils.copyProperties(appointment.getPatient(), patientDTO);
            BeanUtils.copyProperties(appointment.getDoctor(), doctorDTO);
            appointmentDTOS.add(new AppointmentDTO(appointment.getAppCode(), appointment.getTime(), appointment.getDate(), appointment.getAppType(), appointment.isCheck(), patientDTO, doctorDTO, appointment.isCancle()));
        });

        return appointmentDTOS;
    }

    @Override
    public boolean finishAppointment(String appCode) {
        appointmentRepo.finishAppointment(1, appCode);
        return true;
    }

    @Override
    public String getPPAppointmentCountofCurrentDay(String DID) {

        DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate now = LocalDate.now();
        System.out.println(ofPattern.format(now));
        String date = ofPattern.format(now);
        return appointmentRepo.getPPAppointmentCountofCurrentDay(DID, false, false, date, "Private Practice Consultation");

    }

    @Override
    public void cancleAppointment(String appCode) {
        Appointment appointment = appointmentRepo.findById(appCode).get();
        appointment.setCancle(true);
    }

    @Override
    public List<AppointmentDTO> todayAppointmets(String PID) {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.now();
        String date = dtf.format(localDate);
        System.out.println(date);
        System.out.println(PID);
        List<Appointment> appointments = appointmentRepo.todayAppointments(PID, false, date);
        if(appointments.isEmpty()){
            return null;
        }

        List<AppointmentDTO> appointmentDTOS = new ArrayList<>();
        appointments.forEach(app->{
            AppointmentDTO appointmentDTO = new AppointmentDTO();
            DoctorDTO doctorDTO = new DoctorDTO();
            BeanUtils.copyProperties(app,appointmentDTO);
            BeanUtils.copyProperties(app.getDoctor(),doctorDTO);
            appointmentDTO.setDoctorDTO(doctorDTO);
            appointmentDTOS.add(appointmentDTO);
        });

        return appointmentDTOS;


    }


}
