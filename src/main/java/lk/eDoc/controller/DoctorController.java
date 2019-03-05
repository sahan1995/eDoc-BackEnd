package lk.eDoc.controller;

import lk.eDoc.dto.AppointmentDTO;
import lk.eDoc.dto.DoctorDTO;
import lk.eDoc.service.DoctorService;
import lk.eDoc.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
/**
 * This is the Model class for the controlling Doctors
 */
public class DoctorController {



    @Autowired
    private DoctorService docService;

    @Autowired
    private UserService userService;


    Logger logger = LoggerFactory.getLogger(DoctorController.class);


    /**
     * Get all All Doctors
     * @return All Doctors list
     */
    @GetMapping
    public List<DoctorDTO> getAllDoctors(){


        return  docService.getAllDoctors();

    }


    /**
     * Get the Doctor according to the doctor ID (DID)
     * @param DID Doctor ID
     * @return The Doctor DTO
     */
    @GetMapping(value = "/{id}")
    public DoctorDTO findbyID(@PathVariable("id") String DID){


        return docService.findById(DID);
    }

    /**
     * Save the Doctor (DID,doctorDTO)
     * @param DID Doctor ID
     * @param doctorDTO Doctor DTO containing all the information of doctor
     */
    @PutMapping(value = "/{id}")
    public void saveDoctor(@PathVariable("id") String DID,  @RequestBody DoctorDTO doctorDTO){

        System.out.println("Came");
        doctorDTO.setDID(DID);
        System.out.println(doctorDTO);
        docService.saveDoctor(DID,doctorDTO);

    }


    /**
     * Get the last ID of doctor table
     * @return The last ID of Doctor Table
     */
    @GetMapping(path = "/getLastID")
    public String getLastID(){

       return docService.getLastID();
    }


    /**
     * Save the Profile Picture of Doctor (proImg)
     * @param proImg The profile Picture
     * @return The state of isSave or Not. The value will be true or false
     * @throws IOException
     * @throws URISyntaxException
     */
    @PutMapping(path = "/proImg")
    public boolean saveProfile(@RequestPart("proImg") MultipartFile proImg) throws IOException, URISyntaxException {

        System.out.println(proImg.getOriginalFilename());
        return docService.saveImage(proImg);

    }

    /**
     * Check the user name is already taken (userName)
     * @param userName The user name of Doctor
     * @return The state of already taken or not. The value will be true of false
     */
    @GetMapping(path = "/isExsists/{userName}")
    public boolean isUserNameExsists(@PathVariable("userName") String userName){
        return userService.isExists(userName);
    }

    /**
     * Get the all doctors Cities
     * @return The arraylist of Cities
     */
    @GetMapping(path = "/address")
    public ArrayList<String> allAddress(){

        ArrayList<String> address = new ArrayList<>();
        List<DoctorDTO> allDoctors = docService.getAllDoctors();
        allDoctors.forEach(doc->{
           address.add(doc.getCity());

        });
        return address;
    }

    /**
     * Get the Profile Picture according to the picture name(picName)
     * @param picName Picture name
     * @return The bytes of Picture
     */
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

    /**
     * Get tht Appointment list according to the Doctor ID (DID)
     * @param DID Doctor ID
     * @return List of Appointment
     */
    @GetMapping(path = "/getDoctorAppointments")
    public List<AppointmentDTO> getDoctorAppointments(@RequestParam("DID") String DID){

        logger.trace("Get Doctor Appointments");
        return docService.doctorAppointment(DID);

    }

    /**
     * Update the Key of video consultation(DID,Key)
     * @param DID Doctor ID
     * @param Key Key of Video consultation
     */
    @PostMapping(path = "/updateVideoKey")
    public void updateVideoKey(@RequestParam("DID") String DID,@RequestParam("Key") String Key){
        System.out.println(DID);
        System.out.println(Key);
        docService.updateVideoKey(DID, Key);
    }

    /**
     * Get the Video consultation key according to the Doctor ID(DID)
     * @param DID Doctor ID
     * @return The key of Video Consultation
     */

    @GetMapping(path = "/getVideoKey")
    public String getVideoKey(@RequestParam("DID") String DID){

        return docService.getVideoKey(DID);
    }

    /**
     * Get the list of doctor according to specialized
     * @param special Specialized of Doctor
     * @return List of Doctors
     */
    @GetMapping(path = "/getDoctorbySpecial")
    public List<DoctorDTO> getDoctorbySpecial(@RequestParam("special") String special){
        return docService.getDoctorsBySpecilizedIn(special);
    }

    /**
     * Get all Doctors by Their name or hospital of specialized
     * @param param  Keyword to search
     * @return List of Doctors
     */
    @GetMapping(path = "/getDoctor")
    public List<DoctorDTO> getDoctors(@RequestParam("param") String param){

        return docService.getDoctors(param);
    }

}
