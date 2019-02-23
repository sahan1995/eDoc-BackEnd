package lk.eDoc.controller;

import lk.eDoc.dto.PrescriptionDTO;
import lk.eDoc.entity.Prescription;
import lk.eDoc.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "api/v1/prescription",produces = MediaType.APPLICATION_JSON_VALUE)
public class PrescriptionController {

    @Autowired
    PrescriptionService prescriptionService;

    @PutMapping(value = "/{id}")
    boolean addPrescription(@PathVariable("id") String presID, @RequestParam("appCode") String appCode, @RequestBody PrescriptionDTO prescriptionDTO){

        System.out.println(presID);
        System.out.println(appCode);
        System.out.println(prescriptionDTO);

        return prescriptionService.addPrescription(presID,appCode,prescriptionDTO);


    }

    @GetMapping(path = "/getLastID")
    String getLastId(){

        return prescriptionService.getLastId();
    }


}
