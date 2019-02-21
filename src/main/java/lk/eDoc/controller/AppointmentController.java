package lk.eDoc.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lk.eDoc.dto.AppointmentDTO;
import lk.eDoc.service.AppointmentService;
import lk.eDoc.service.DoctorService;
import lk.eDoc.service.PatientService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "api/v1/appointments", produces = MediaType.APPLICATION_JSON_VALUE)
public class AppointmentController {

    @Autowired
    AppointmentService appointmentSe;

    @Autowired
    DoctorService doctorService;

    @Autowired
    PatientService patientService;

    @GetMapping(path = "/isBooked")
    Boolean isBooked(@RequestParam("DID") String DID, @RequestParam("date") String date, @RequestParam("time") String time) {
        return appointmentSe.checkAppointmentAvalable(DID, date, time);

    }

    @GetMapping(path = "/lastID")
    String lastID() {
        return appointmentSe.getLastID();
    }

    @PutMapping(value = "/{appCode}")
    boolean saveAppointment(@PathVariable("appCode") String appCode, @RequestBody String JSON) {

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

    @GetMapping(value = "/{appCode}")
    AppointmentDTO findByCode(@PathVariable("appCode") String appCode) {
        return appointmentSe.findByID(appCode);
    }

    @GetMapping(path = "/findByType")
    List<AppointmentDTO> findByAppType(@RequestParam("appType") String appType, @RequestParam("DID") String DID) {


        return appointmentSe.findByApptype(appType, DID);
    }

    @GetMapping(path = "/findByDate")
    List<AppointmentDTO> findByDate(@RequestParam("date") String date, @RequestParam("DID") String DID) {

        return appointmentSe.findByDate(date, DID);

    }

    @GetMapping(path = "/findByDateAndType")
    List<AppointmentDTO> findByDateAndType(@RequestParam("date") String date, @RequestParam("DID") String DID, @RequestParam("appType") String appType ){
        return appointmentSe.findByDateAndType(date,DID,appType);
    }
}
