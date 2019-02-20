package lk.eDoc.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lk.eDoc.dto.PatientDTO;
import lk.eDoc.service.PatientService;
import lk.eDoc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
@CrossOrigin(origins = {"http://localhost:4200"})
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

}
