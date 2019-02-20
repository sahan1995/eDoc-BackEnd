package lk.eDoc.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class DoctorTel {


    @ManyToOne
    @JoinColumn(name = "DID",referencedColumnName = "DID")
    private
    Doctor doctor;

    @Id
    private
    String tel;


    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public DoctorTel(Doctor doctor, String tel) {
        this.doctor = doctor;
        this.tel = tel;
    }

    public DoctorTel() {
    }

    @Override
    public String toString() {
        return "DoctorTel{" +
                "doctor=" + doctor +
                ", tel='" + tel + '\'' +
                '}';
    }
}
