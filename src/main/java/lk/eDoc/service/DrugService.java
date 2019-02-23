package lk.eDoc.service;

import lk.eDoc.dto.DrugDTO;

public interface DrugService  {

   boolean addDrug(String presID,DrugDTO drugDTO);

}
