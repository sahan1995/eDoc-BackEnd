package lk.eDoc.service;

import lk.eDoc.dto.PrivatePracticeDTO;

public interface PrivatePracticeService {

    boolean hasPP(String DID);

    PrivatePracticeDTO getByID(String PPID);

    void registerPP(PrivatePracticeDTO privatePracticeDTO);

    String getLastID();


}
