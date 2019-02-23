package lk.eDoc.service.impl;

import lk.eDoc.dto.DrugDTO;
import lk.eDoc.entity.Drug;
import lk.eDoc.repository.DrugRepository;
import lk.eDoc.repository.PrescriptionRepository;
import lk.eDoc.service.DrugService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class DrugServiceImpl implements DrugService {

    @Autowired
    private DrugRepository drugRepository;

    @Autowired
    private PrescriptionRepository prescriptionRepository;
    @Override
    public boolean addDrug(String presID,DrugDTO drugDTO) {

        Drug drug = new Drug();
        BeanUtils.copyProperties(drugDTO,drug);
        drug.setPrescription(prescriptionRepository.findById(presID).get());
        drugRepository.save(drug);
        return true;


    }
}
