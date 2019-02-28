package lk.eDoc.controller;

import lk.eDoc.dto.AppointmentDTO;
import lk.eDoc.dto.DoctorDTO;
import lk.eDoc.service.DoctorService;
import lk.eDoc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.DataOutput;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping(value = "api/v1/doctors")
public class DoctorController {


    @Autowired
    private DoctorService docService;

    @Autowired
    private UserService userService;
    @GetMapping
    public List<DoctorDTO> getAllDoctors(){


        return  docService.getAllDoctors();

    }

    @GetMapping(value = "/{id}")
    public DoctorDTO findbyID(@PathVariable("id") String DID){


        return docService.findById(DID);
    }

    @PutMapping(value = "/{id}")
    public void saveDoctor(@PathVariable("id") String DID,  @RequestBody DoctorDTO doctorDTO){

        System.out.println("Came");
        doctorDTO.setDID(DID);
        System.out.println(doctorDTO);
        docService.saveDoctor(DID,doctorDTO);

    }

    @GetMapping(path = "/getLastID")
    public String getLastID(){


       return docService.getLastID();
    }
    @PutMapping(path = "/proImg")
    public boolean saveProfile(@RequestPart("proImg") MultipartFile proImg) throws IOException, URISyntaxException {

        System.out.println(proImg.getOriginalFilename());
        return docService.saveImage(proImg);

    }
    @GetMapping(path = "/isExsists/{userName}")
    public boolean isUserNameExsists(@PathVariable("userName") String userName){
        return userService.isExists(userName);
    }

    @GetMapping(path = "/address")
    public ArrayList<String> allAddress(){

        ArrayList<String> address = new ArrayList<>();
        List<DoctorDTO> allDoctors = docService.getAllDoctors();
        allDoctors.forEach(doc->{
           address.add(doc.getCity());

        });
        return address;
    }

    @GetMapping(path="/getPic",produces = {"image/jpeg","image/png"})
    public byte[] getProfilePic(@RequestParam("picName") String picName){

        try {
            return docService.getProfilePic(picName);

        } catch (URISyntaxException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping(path = "/getDoctorAppointments")
    public List<AppointmentDTO> getDoctorAppointments(@RequestParam("DID") String DID){

        return docService.doctorAppointment(DID);
    }


    @PostMapping(path = "/updateVideoKey")
    public void updateVideoKey(@RequestParam("DID") String DID,@RequestParam("Key") String Key){
        System.out.println(DID);
        System.out.println(Key);
        docService.updateVideoKey(DID, Key);
    }


    @GetMapping(path = "/getVideoKey")
    public String getVideoKey(@RequestParam("DID") String DID){

        return docService.getVideoKey(DID);
    }

    @GetMapping(path = "/getDoctorbySpecial")
    List<DoctorDTO> getDoctorbySpecial(@RequestParam("special") String special){
        return docService.getDoctorsBySpecilizedIn(special);
    }

    @GetMapping(path = "/getDoctor")
    List<DoctorDTO> getDoctors(@RequestParam("param") String param){

        return docService.getDoctors(param);
    }

}
