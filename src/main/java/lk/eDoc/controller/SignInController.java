package lk.eDoc.controller;

import javafx.application.Application;
import lk.eDoc.dto.DoctorDTO;
import lk.eDoc.dto.LoginDetailDTO;
import lk.eDoc.dto.PatientDTO;
import lk.eDoc.service.DoctorService;
import lk.eDoc.service.PatientService;
import lk.eDoc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping(value = "api/v1/signIn")
public class SignInController {

    @Autowired
    UserService userService;

    @Autowired
    PatientService patientService;

    @Autowired
    DoctorService doctorService;

    @Autowired
     HttpServletRequest httpServletRequest;

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    LoginDetailDTO SignIn(@RequestParam("uname") String uname, @RequestParam("password") String password) {

        Map<String, String> userDetail = userService.signIn(uname, password);
        if (userDetail.isEmpty()) {
            return null;
        } else {

            String role = userDetail.get("role");
            String useID = userDetail.get("useID");
            if(role.equals("patient")) {
                PatientDTO patient = patientService.findByID(useID);
                return  new LoginDetailDTO(patient.getPID(), patient.getFname(), patient.getLname(), role,patient.getLat(),patient.getLng(),patient.getEmail());


            }else if(role.equals("doctor")){

                DoctorDTO doctor = doctorService.findById(useID);
                return new LoginDetailDTO(useID,doctor.getFname(),doctor.getLname(),role,doctor.getLat(),doctor.getLng(),doctor.getEmail());
            }else{
                return null;
            }
        }

    }

    @GetMapping
    void getSession() {
        System.out.println(httpServletRequest.getSession().getAttribute("useID"));

    }

}
