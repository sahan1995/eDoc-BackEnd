package lk.eDoc.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class DoctorRequestForFamDoc_PK implements Serializable {
    private String PID;

    private String DID;

    public String getPID() {
        return PID;
    }

    public void setPID(String PID) {
        this.PID = PID;
    }

    public String getDID() {
        return DID;
    }

    public void setDID(String DID) {
        this.DID = DID;
    }

    public DoctorRequestForFamDoc_PK(String PID, String DID) {
        this.PID = PID;
        this.DID = DID;
    }

    public DoctorRequestForFamDoc_PK() {
    }

    @Override
    public String toString() {
        return "PatientFamDoc_PK{" +
                "PID='" + PID + '\'' +
                ", DID='" + DID + '\'' +
                '}';
    }
}
