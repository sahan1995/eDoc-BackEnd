package lk.eDoc.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PatientTel {


    @ManyToOne
    @JoinColumn(name = "PID",referencedColumnName = "PID")
    private Patient patient;

    @Id
    private String tel;


    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public PatientTel(Patient patient, String tel) {
        this.patient = patient;
        this.tel = tel;
    }

    public PatientTel() {
    }
}
