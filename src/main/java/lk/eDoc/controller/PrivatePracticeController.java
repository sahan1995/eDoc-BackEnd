package lk.eDoc.controller;

import lk.eDoc.dto.PrivatePracticeDTO;
import lk.eDoc.service.PrivatePracticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Path;

@CrossOrigin
@RestController
@RequestMapping(value = "api/v1/privatepractices")
public class PrivatePracticeController {



    @Autowired
    PrivatePracticeService privatePracticeService;

    @GetMapping(path = "/hasPP")
    public boolean hasPP(@RequestParam("DID") String DID){
        return  privatePracticeService.hasPP(DID);
    }


    @PutMapping(value = "/{ppID}")
    public void registerPP(@PathVariable("ppID")String PPID, @RequestBody PrivatePracticeDTO privatePracticeDTO){

        System.out.println(PPID);
        privatePracticeDTO.setPPID(PPID);
        System.out.println(privatePracticeDTO);

        privatePracticeService.registerPP(privatePracticeDTO);
    }


    @GetMapping(value = "/{ppID}")
    public PrivatePracticeDTO findByID(@PathVariable("ppID") String PPID){
        return  privatePracticeService.getByID(PPID);
    }

    @GetMapping(value = "/getLastID")
    public String getLastID(){
        return privatePracticeService.getLastID();
    }


}
