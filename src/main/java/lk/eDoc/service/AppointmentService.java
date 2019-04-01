package lk.eDoc.service;

import lk.eDoc.dto.AppointmentDTO;
import lk.eDoc.entity.Appointment;
import org.springframework.data.repository.query.Param;

import java.sql.Time;
import java.util.Date;
import java.util.List;

public interface AppointmentService {


    List<AppointmentDTO> getAllAppointment();

    boolean addAppointment(String appCpde,AppointmentDTO appointmentDTO);

    boolean checkAppointmentAvalable(String DID, String date, String time);

    public String getLastID();

    AppointmentDTO findByID(String appCode);

    List<AppointmentDTO> findByApptype(String appType,String DID);

    List<AppointmentDTO> findByDate(String date,String DID);

    List<AppointmentDTO> findByDateAndType(String date,String DID,String appType);

    boolean finishAppointment(String appCode);

    String getPPAppointmentCountofCurrentDay(String DID);

    void cancleAppointment(String appCode);

    List<AppointmentDTO> todayAppointmets(String PID);

    List<AppointmentDTO> todayDocAppointmets(String DID);
}
