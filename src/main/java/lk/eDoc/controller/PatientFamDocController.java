package lk.eDoc.controller;

import lk.eDoc.service.PatientFamDocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "api/v1/patientFamDoc")
public class PatientFamDocController {

    @Autowired
    PatientFamDocService patientFamDocService;



    @GetMapping(path = "/isFamDoc")
    boolean isFamDoc(@RequestParam("PID") String PID, @RequestParam("DID") String DID){
        return patientFamDocService.ifFamDoc(PID, DID);

    }

    @PutMapping
    boolean addPatient(@RequestParam("PID") String PID,@RequestParam("DID") String DID){

        return patientFamDocService.addPatient(PID, DID);
    }
    @DeleteMapping
    boolean removeFamDoc(@RequestParam("PID") String PID,@RequestParam("DID") String DID){
        return patientFamDocService.removeDoctor(PID, DID);

    }


}
