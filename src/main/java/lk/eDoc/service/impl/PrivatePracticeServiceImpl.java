package lk.eDoc.service.impl;

import lk.eDoc.dto.DoctorDTO;
import lk.eDoc.dto.PrivatePracticeDTO;
import lk.eDoc.entity.Doctor;
import lk.eDoc.entity.PrivatePrictice;
import lk.eDoc.repository.PrivatePracticeRepository;
import lk.eDoc.service.PrivatePracticeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class PrivatePracticeServiceImpl implements PrivatePracticeService {

    @Autowired
    PrivatePracticeRepository privatePracticeRepository;


    @Override
    public boolean hasPP(String DID) {
        return  privatePracticeRepository.hasPP(DID).isPresent();
    }

    @Override
    public PrivatePracticeDTO getByID(String PPID) {
        PrivatePrictice privatePrictice =
                privatePracticeRepository.findById(PPID).get();

        Doctor doctor =
                privatePrictice.getDoctor();

        PrivatePracticeDTO privatePracticeDTO = new PrivatePracticeDTO();
        DoctorDTO doctorDTO = new DoctorDTO();
        BeanUtils.copyProperties(privatePrictice,privatePracticeDTO);
        BeanUtils.copyProperties(doctor,doctorDTO);

        privatePracticeDTO.setDoctorDTO(doctorDTO);

        return privatePracticeDTO;

    }

    @Override
    public void registerPP(PrivatePracticeDTO privatePracticeDTO) {

        PrivatePrictice privatePrictice = new PrivatePrictice();
        Doctor doctor = new Doctor();
        BeanUtils.copyProperties(privatePracticeDTO.getDoctorDTO(),doctor);
        BeanUtils.copyProperties(privatePracticeDTO,privatePrictice);

        privatePrictice.setDoctor(doctor);
        privatePracticeRepository.save(privatePrictice);
    }

    @Override
    public String getLastID() {
        return privatePracticeRepository.getCount();
    }
}
