package lk.eDoc.entity;

import javax.persistence.*;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class PatientSymptoms {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE,generator = "G1")
    @TableGenerator(name = "G1",table = "AutoIncermant",allocationSize = 1,valueColumnName = "patientSymptomsID")
    private
    int ID;

    @ManyToOne
    @JoinColumn(name = "PID",referencedColumnName = "PID")
    private
    Patient patient;

    @ManyToOne
    @JoinColumn(name = "syID",referencedColumnName = "syID")
    private
    Symptom symptom;

    @Temporal(TemporalType.DATE)
    private
    Date date;


    private
    Time time;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "patientSymptomsOFdoctor",
            joinColumns = {@JoinColumn(name = "ID",referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "DID",referencedColumnName = "DID")}
    )
    private
    List<Doctor> doctors = new ArrayList<>();
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Symptom getSymptom() {
        return symptom;
    }

    public void setSymptom(Symptom symptom) {
        this.symptom = symptom;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public PatientSymptoms(Date date, Time time) {
        this.date = date;
        this.time = time;
    }

    @Override
    public String toString() {
        return "PatientSymptoms{" +
                "ID=" + ID +
                ", date=" + date +
                ", time=" + time +
                '}';
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }
}
