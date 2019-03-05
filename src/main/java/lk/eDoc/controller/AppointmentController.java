package lk.eDoc.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lk.eDoc.dto.AppointmentDTO;
import lk.eDoc.service.AppointmentService;
import lk.eDoc.service.DoctorService;
import lk.eDoc.service.PatientService;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "api/v1/appointments", produces = MediaType.APPLICATION_JSON_VALUE)

/**
 * This is the model class for the controlling Appointments
 */
public class AppointmentController {

    @Autowired
    AppointmentService appointmentSe;  //Appointment Service Implementation

    @Autowired
    DoctorService doctorService; //Doctor Service Implementation

    @Autowired
    PatientService patientService; //Patient  Service Implementation


    Logger logger = LoggerFactory.getLogger(AppointmentController.class);

    /**
     * Checks the date and time of appointment is already reserved(DID,date,time) This Get Mapping and path is '/isBooked'
     *
     * @param DID  Doctor ID
     * @param date Date of Appointment
     * @param time Time of Appointment
     * @return The state of already reserved or not. The value will be true of false
     */
    @GetMapping(path = "/isBooked")
    public Boolean isBooked(@RequestParam("DID") String DID, @RequestParam("date") String date, @RequestParam("time") String time) {
        return appointmentSe.checkAppointmentAvalable(DID, date, time);

    }

    /**
     * Get the last ID of appointments. This is Get Mapping and Path is '/lastID'
     *
     * @return The last ID of appointments
     */
    @GetMapping(path = "/lastID")
    public String lastID() {
        return appointmentSe.getLastID();
    }

    /**
     * Save the appointment in the database(appCode,JSON) This is Put Mapping
     *
     * @param appCode The Appointment Code
     * @param JSON    Appointment details in JSON format
     * @return The state of isSave or Not. The value will be true or false
     */
    @PutMapping(value = "/{appCode}")
    public boolean saveAppointment(@PathVariable("appCode") String appCode, @RequestBody String JSON) {

//        System.out.println(JSON);

        JSONObject jsonObject = new JSONObject(JSON);

        String appCode1 = jsonObject.get("appCode").toString();
        String time = jsonObject.get("time").toString();
        String date = jsonObject.get("date").toString();
        String appType = jsonObject.get("appType").toString();
        String did = jsonObject.get("DID").toString();
        String pid = jsonObject.get("PID").toString();

        AppointmentDTO appointmentDTO = new AppointmentDTO(appCode1, time, date, appType, false, patientService.findByID(pid), doctorService.findById(did), false);


        System.out.println(appointmentDTO);

        appointmentSe.addAppointment(appCode, appointmentDTO);
        return false;
    }

    /**
     * Get the appointment according to the Appointment Code (appCode). This is Get Mapping
     *
     * @param appCode
     * @return The Appointment
     */
    @GetMapping(value = "/{appCode}")
    public AppointmentDTO findByCode(@PathVariable("appCode") String appCode) {
        return appointmentSe.findByID(appCode);
    }

    /**
     * Get the appointment list according to the Appointment type and Doctor ID (appType,DID). This is a Get Mapping and path is '/findByType'
     *
     * @param appType The type of Appointment
     * @param DID     The Doctor ID
     * @return The list of Appointments
     */
    @GetMapping(path = "/findByType")
    public List<AppointmentDTO> findByAppType(@RequestParam("appType") String appType, @RequestParam("DID") String DID) {


        return appointmentSe.findByApptype(appType, DID);
    }

    @PostMapping(path = "/findByDate")
    public List<AppointmentDTO> findByDate(@RequestParam("date") String date, @RequestParam("DID") String DID) {

        return appointmentSe.findByDate(date, DID);

    }

    /**
     * Get the appointment list according to the Date, Doctor ID and Appointment Type(date,DID,appType).This is a GetMapping and Path is '/findByDateAndType'
     *
     * @param date    The Date of Appointment
     * @param DID     The Doctor ID
     * @param appType The type of Appointment
     * @return The list of Appointments
     */
    @GetMapping(path = "/findByDateAndType")
    public List<AppointmentDTO> findByDateAndType(@RequestParam("date") String date, @RequestParam("DID") String DID, @RequestParam("appType") String appType) {
        return appointmentSe.findByDateAndType(date, DID, appType);
    }

    /**
     * Update the appointment as finish (appCode). This is s Post Mapping and path is '/finishAppointment
     *
     * @param appCode The Appointment Code
     * @return The state of isUpdate or Not. The value will be true or false
     */
    @PostMapping(path = "/finishAppointment")
    public boolean finishAppointment(@RequestParam("appCode") String appCode) {
        System.out.println(appCode);
        return appointmentSe.finishAppointment(appCode);
    }


}
