package lk.eDoc.controller;

import lk.eDoc.dto.DrugDTO;
import lk.eDoc.service.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "api/v1/drugs",produces = MediaType.APPLICATION_JSON_VALUE)
public class DrugController {

    @Autowired
    private DrugService drugService;

    @PutMapping
    boolean addDrug(@RequestParam("presID") String preID,@RequestBody DrugDTO drugDTO){

        System.out.println(drugDTO);
        return  drugService.addDrug(preID,drugDTO);


    }


}
