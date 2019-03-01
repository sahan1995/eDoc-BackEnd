package lk.eDoc.entity;

import javax.persistence.*;

@Entity
public class DoctorRequestForFamDoc {


    @EmbeddedId
    private DoctorRequestForFamDoc_PK doctorRequestForFamDoc_pk;

    private boolean isCancle;


    private boolean isAccept;

    @ManyToOne
    @JoinColumn(name = "PID",referencedColumnName = "PID",insertable = false,updatable = false)
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "DID",referencedColumnName = "DID",insertable = false,updatable = false)
    private Doctor doctor;

    public DoctorRequestForFamDoc(DoctorRequestForFamDoc_PK doctorRequestForFamDoc_pk, boolean isCancle, boolean isAccept, Patient patient, Doctor doctor) {
        this.doctorRequestForFamDoc_pk = doctorRequestForFamDoc_pk;
        this.isCancle = isCancle;
        this.isAccept = isAccept;
        this.patient = patient;
        this.doctor = doctor;
    }
    public DoctorRequestForFamDoc(String PID,String DID, boolean isCancle,boolean isAccept, Patient patient, Doctor doctor) {
        this.doctorRequestForFamDoc_pk = new DoctorRequestForFamDoc_PK(PID,DID);
        this.isCancle = isCancle;
        this.isAccept = isAccept;
        this.patient = patient;
        this.doctor = doctor;
    }

    public DoctorRequestForFamDoc() {
    }

    public DoctorRequestForFamDoc_PK getDoctorRequestForFamDoc_pk() {
        return doctorRequestForFamDoc_pk;
    }

    public void setDoctorRequestForFamDoc_pk(DoctorRequestForFamDoc_PK doctorRequestForFamDoc_pk) {
        this.doctorRequestForFamDoc_pk = doctorRequestForFamDoc_pk;
    }

    public boolean isCancle() {
        return isCancle;
    }

    public void setCancle(boolean cancle) {
        isCancle = cancle;
    }

    public boolean isAccept() {
        return isAccept;
    }

    public void setAccept(boolean accept) {
        isAccept = accept;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }


    @Override
    public String toString() {
        return "DoctorRequestForFamDoc{" +
                "doctorRequestForFamDoc_pk=" + doctorRequestForFamDoc_pk +
                ", isCancle=" + isCancle +
                ", isAccept=" + isAccept +
                ", patient=" + patient +
                ", doctor=" + doctor +
                '}';
    }
}
