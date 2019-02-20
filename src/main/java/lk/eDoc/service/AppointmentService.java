package lk.eDoc.service;

import lk.eDoc.dto.AppointmentDTO;

import java.sql.Time;
import java.util.Date;
import java.util.List;

public interface AppointmentService {


    List<AppointmentDTO> getAllAppointment();

    boolean addAppointment(String appCpde,AppointmentDTO appointmentDTO);

    boolean checkAppointmentAvalable(String DID, String date, String time);

    public String getLastID();

    AppointmentDTO findByID(String appCode);
}
