package lk.eDoc.controller;

import lk.eDoc.dto.DoctorRequestFamDocDTO;
import lk.eDoc.service.DoctorRequsetFamDocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "api/v1/requestForDoctor")
public class DoctorReqestFamDocController {

    @Autowired
    DoctorRequsetFamDocService doctorRequsetFamDocService;


    @PutMapping
    boolean saveRequest(@RequestParam("PID")String PID,@RequestParam("DID") String DID){

        return doctorRequsetFamDocService.sendRequest(PID,DID);
    }

    @GetMapping(path = "/isPresent")
    boolean isPresent(@RequestParam("PID")String PID,@RequestParam("DID") String DID){
        return  doctorRequsetFamDocService.isSendRequest(PID, DID);
    }

    @DeleteMapping
    boolean deleteRequest(@RequestParam("PID") String PID,@RequestParam("DID") String DID){

        return doctorRequsetFamDocService.deleteRequest(PID, DID);
    }

    @GetMapping(path = "/getDoctorRequests")
    List<DoctorRequestFamDocDTO> getDoctorRequests(@RequestParam("DID") String DID){

        return  doctorRequsetFamDocService.findDoctorRequest(DID);
    }

    @PostMapping(path = "/updateIsAccept")
    void updateIsAccept(@RequestParam("PID") String PID,@RequestParam("DID") String DID){

        System.out.println("Con "+PID);

        System.out.println("Con "+DID);

        doctorRequsetFamDocService.updateIsAccept(PID, DID);
    }
}
