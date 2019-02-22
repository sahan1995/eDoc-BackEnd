package lk.eDoc.controller;

import lk.eDoc.dto.MedicalReportDTO;
import lk.eDoc.entity.MedicalReport;
import lk.eDoc.service.MedicalReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "api/v1/medicalReports",produces = MediaType.APPLICATION_JSON_VALUE)
public class MedicalReportController {

    @Autowired
    MedicalReportService medicalReportService;


    @GetMapping()
    List<MedicalReportDTO> getByID(){

        return medicalReportService.getAll();
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    void addReport(@RequestBody MedicalReportDTO medicalReportDTO){
        medicalReportService.addMedicalReport(medicalReportDTO);
    }

}
