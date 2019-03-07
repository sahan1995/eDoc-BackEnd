package lk.eDoc.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lk.eDoc.dto.AppointmentDTO;
import lk.eDoc.dto.PatientDTO;
import lk.eDoc.service.PatientService;
import lk.eDoc.service.UserService;
import org.omg.PortableServer.POA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.ws.rs.GET;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping(value = "api/v1/patients", produces = {MediaType.APPLICATION_JSON_VALUE})
public class PatientController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private UserService userService;

    @GetMapping
    public List<PatientDTO> getAllPatients(){
        return  patientService.getAllPatient();

    }

    @GetMapping(value = "/{id}")
    public PatientDTO findById(@PathVariable("id") String PID){ return  patientService.findByID(PID);}

    @PutMapping(value = "/{id}")
    public void savePatient(@PathVariable("id") String PID,@RequestBody PatientDTO patientDTO){
//        PatientDTO patientDTO;
        System.out.println("methent endwa");
        try {
//            patientDTO = new ObjectMapper().readValue(patient, PatientDTO.class);
            patientDTO.setPID(PID);
            System.out.println(patientDTO+" "+PID);
//            patientService.saveProfileImage(image);
            patientService.savePatient(PID,patientDTO);


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @PostMapping(value = "/{id}")
    public void updatePatient(@PathVariable("id") String PID,@RequestBody PatientDTO patientDTO){
        patientService.updatePatient(PID,patientDTO);
    }

    @DeleteMapping(value = "/{id}")
    public void DeletePatient(@PathVariable("id") String PID){
        patientService.deletePatient(PID);
    }

    @GetMapping(path = "/isExists")
    public boolean IsUserNameExists(@RequestParam("userName") String userName){
        return userService.isExists(userName);
    }

    @GetMapping(path = "/getLastID")
    public String getLastID(){
        return patientService.getLastID();
    }

    @PutMapping(path = "/uploadPic",consumes = MediaType.MULTIPART_FORM_DATA_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public void uploadProPic(@RequestPart("proPic") MultipartFile proPic){
        try {
            System.out.println(proPic.getOriginalFilename());
            patientService.saveProfileImage(proPic);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @GetMapping(path="/getPic",produces = {"image/jpeg","image/png"})
    byte[] getProfilePic(@RequestParam("picName") String profilePicName) throws IOException, URISyntaxException {

        return patientService.getProfilePicture(profilePicName);
    }

    @PostMapping(path = "/updateVideoKey")
    public void updateVideoKey(@RequestParam("PID") String PID,@RequestParam("Key") String Key){
        patientService.updateVideoKey(PID, Key);
    }


    @GetMapping(path = "/getVideoKey")
    public String getVideoKey(@RequestParam("PID") String PID){

        return patientService.getVideoKey(PID);
    }

    @GetMapping(path = "/patientAppointments")
    List<AppointmentDTO> getPatientAppointments(@RequestParam("PID") String PID){

        return  patientService.patientAppointments(PID);
    }

    @GetMapping(path = "/getAppointmentByType")
    List<AppointmentDTO> getAppointmentByType(@RequestParam("PID")String PID,@RequestParam("appType")String type){
        return patientService.getAppointmentbyType(PID,type);
    }

    /**
     * Get All finished appointment according to the Patient ID
     * @param PID Patient ID
     * @return List of finished Appointments
     */
    @GetMapping(path = "/finishedAppointmet")
    List<AppointmentDTO> getFinishedAppointments(@RequestParam("PID") String PID){
        return  patientService.getFinishedAppointments(PID);
    }

}
