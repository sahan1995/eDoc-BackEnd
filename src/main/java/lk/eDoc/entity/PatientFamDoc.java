package lk.eDoc.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PatientFamDoc {

    @EmbeddedId
    private
    PatientFamDoc_PK patientFamDoc_pk;

    @ManyToOne
    @JoinColumn(name = "PID",referencedColumnName = "PID",insertable = false,updatable = false)
    private
    Patient patient;

    @ManyToOne
    @JoinColumn(name = "DID",referencedColumnName = "DID",insertable = false,updatable = false)
    private
    Doctor doctor;

    public PatientFamDoc_PK getPatientFamDoc_pk() {
        return patientFamDoc_pk;
    }

    public void setPatientFamDoc_pk(PatientFamDoc_PK patientFamDoc_pk) {
        this.patientFamDoc_pk = patientFamDoc_pk;
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

    public PatientFamDoc(PatientFamDoc_PK patientFamDoc_pk, Patient patient, Doctor doctor) {
        this.patientFamDoc_pk = patientFamDoc_pk;
        this.patient = patient;
        this.doctor = doctor;
    }
    public PatientFamDoc(String PID, String DID, Patient patient, Doctor doctor) {
        this.patientFamDoc_pk = new PatientFamDoc_PK(PID,DID);
        this.patient = patient;
        this.doctor = doctor;
    }

    public PatientFamDoc() {
    }

    @Override
    public String toString() {
        return "PatientFamDoc{" +
                "patientFamDoc_pk=" + patientFamDoc_pk +
                ", patient=" + patient +
                ", doctor=" + doctor +
                '}';
    }
}
