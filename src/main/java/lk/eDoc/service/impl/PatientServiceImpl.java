package lk.eDoc.service.impl;

import lk.eDoc.dto.PatientDTO;
import lk.eDoc.dto.PatientTelDTO;
import lk.eDoc.dto.UserDTO;
import lk.eDoc.entity.Patient;
import lk.eDoc.entity.PatientTel;
import lk.eDoc.entity.User;
import lk.eDoc.repository.PatientRepository;
import lk.eDoc.service.PatientService;
import lk.eDoc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PatientServiceImpl implements PatientService {


    @Autowired
    PatientRepository patientRepository;

    @Autowired
    UserService userService;
    @Override
    public List<PatientDTO> getAllPatient() {

        List<PatientDTO> patientDTOS  = new ArrayList<>();
        List<Patient> allPatients = patientRepository.findAll();


        allPatients.forEach(patient -> {

            patientDTOS.add(new PatientDTO(patient.getPID(),patient.getFname(),patient.getMname(),patient.getLname(),
                    patient.getGender(),patient.getDob(),patient.getNIC(),patient.getCountry(),patient.getCity(),patient.getLane(),
                    patient.getCode(),patient.getLat(),patient.getLng(),patient.getProfilePic()
            ));
        });
            return patientDTOS;

    }

    @Override
    public PatientDTO findByID(String PID) {
        Optional<Patient> byId =
                patientRepository.findById(PID);
        Patient patient = byId.get();

        return new PatientDTO(patient.getPID(), patient.getFname(), patient.getMname(),
                patient.getLname(), patient.getGender(), patient.getDob(), patient.getNIC(),
                patient.getCountry(), patient.getCity(), patient.getLane(), patient.getCode(), patient.getLat(),
                patient.getLng(), patient.getProfilePic());
    }

    @Override
    public void savePatient(String PID,PatientDTO patientDTO) {

        if(!PID.equals(patientDTO.getPID())){
            throw  new RuntimeException("ID Not Same");
        }
        UserDTO userDTO = new UserDTO(patientDTO.getUname(), patientDTO.getPassword(), patientDTO.getRole(), patientDTO.getPID());

        List<PatientTelDTO> patientTelDTOList = patientDTO.getPatientTelDTOList();

        List<PatientTel> patientTels  = new ArrayList<>();

        Patient patient = new Patient(patientDTO.getPID(), patientDTO.getFname(), patientDTO.getMname(),
                patientDTO.getLname(), patientDTO.getGender(), patientDTO.getDob(), patientDTO.getIdenty(),
                patientDTO.getCountry(), patientDTO.getCity(), patientDTO.getLane(), patientDTO.getCode(), patientDTO.getLat(),
                patientDTO.getLng(), patientDTO.getProfilePic());


        for (PatientTelDTO patientTel : patientTelDTOList) {
            patientTels.add(new PatientTel(patient,patientTel.getTel()));
        }
        userService.saveUser(userDTO.getUname(),userDTO);

        patientRepository.save(patient);
        patient.setPatientTels(patientTels);

    }

    @Override
    public void updatePatient(String PID, PatientDTO patientDTO) {

        if(!PID.equals(patientDTO.getPID())){
            throw new RuntimeException("IDs Not Same");
        }
        List<PatientTelDTO> patientTelDTOList = patientDTO.getPatientTelDTOList();
        List<PatientTel> patientTels  = new ArrayList<>();
        Patient patient = new Patient(patientDTO.getPID(), patientDTO.getFname(), patientDTO.getMname(),
                patientDTO.getLname(), patientDTO.getGender(), patientDTO.getDob(), patientDTO.getIdenty(),
                patientDTO.getCountry(), patientDTO.getCity(), patientDTO.getLane(), patientDTO.getCode(), patientDTO.getLat(),
                patientDTO.getLng(), patientDTO.getProfilePic());
        for (PatientTelDTO patientTel : patientTelDTOList) {
            patientTels.add(new PatientTel(patient,patientTel.getTel()));
        }
        patientRepository.save(patient);

        patient.setPatientTels(patientTels);
    }

    @Override
    public void deletePatient(String PID) {
        patientRepository.deleteById(PID);
        System.out.println("This Delete");
    }

    @Override
    public boolean saveProfileImage(MultipartFile image) throws Exception {
        String projectPath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getAbsolutePath();
        File uploadDir = new File(projectPath + "/uploads");
        uploadDir.mkdir();
        image.transferTo(new File(uploadDir.getAbsolutePath()+"/"+image.getOriginalFilename()));
        return true;

    }

    @Override
    public String getLastID() {

        String lastID1 = patientRepository.getLastID();

        if(lastID1.equals("")){
            return null;
        }
        return lastID1;
    }


}
