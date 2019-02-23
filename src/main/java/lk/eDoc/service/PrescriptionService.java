package lk.eDoc.service;

import lk.eDoc.dto.PrescriptionDTO;
import lk.eDoc.repository.PrescriptionRepository;

public interface PrescriptionService  {

    boolean addPrescription(String prescID, String AppCode, PrescriptionDTO prescriptionDTO);

    String getLastId();

}
