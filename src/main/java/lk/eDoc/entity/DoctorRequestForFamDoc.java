package lk.eDoc.entity;

import javax.persistence.*;

@Entity
public class DoctorRequestForFamDoc {


    @EmbeddedId
    private DoctorRequestForFamDoc_PK doctorRequestForFamDoc_pk;

    private boolean isCancle;


    @ManyToOne
    @JoinColumn(name = "PID",referencedColumnName = "PID",insertable = false,updatable = false)
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "DID",referencedColumnName = "DID",insertable = false,updatable = false)
    private Doctor doctor;

    public DoctorRequestForFamDoc(DoctorRequestForFamDoc_PK doctorRequestForFamDoc_pk, boolean isCancle, Patient patient, Doctor doctor) {
        this.doctorRequestForFamDoc_pk = doctorRequestForFamDoc_pk;
        this.isCancle = isCancle;
        this.patient = patient;
        this.doctor = doctor;
    }
    public DoctorRequestForFamDoc(String PID,String DID, boolean isCancle, Patient patient, Doctor doctor) {
        this.doctorRequestForFamDoc_pk = new DoctorRequestForFamDoc_PK(PID,DID);
        this.isCancle = isCancle;
        this.patient = patient;
        this.doctor = doctor;
    }

    public DoctorRequestForFamDoc() {
    }

    @Override
    public String toString() {
        return "DoctorRequestForFamDoc{" +
                "doctorRequestForFamDoc_pk=" + doctorRequestForFamDoc_pk +
                ", isCancle=" + isCancle +
                ", patient=" + patient +
                ", doctor=" + doctor +
                '}';
    }
}
