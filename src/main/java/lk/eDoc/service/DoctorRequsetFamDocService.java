package lk.eDoc.service;

public interface DoctorRequsetFamDocService {

    boolean sendRequest(String PID,String DID);

    boolean isSendRequest(String PID,String DID);

    boolean deleteRequest(String PID,String DID);
}
