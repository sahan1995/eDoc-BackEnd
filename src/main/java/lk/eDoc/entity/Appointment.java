package lk.eDoc.entity;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
@NamedQueries({
        @NamedQuery(name = Appointment.Query,query =  "select a from Appointment a ORDER BY a.AppCode DESC" +"")
})

//@NamedQuery(name = Appointment.Query,query = "SELECT a FROM Appointment a WHERE a.DID= :DID AND a.date= :date AND a.time= :time AND a.isCheck= :isCheck " )
public class Appointment {

    @Transient
    public static final String Query = "Appointment.getLastID";

    @Id
    private
    String AppCode;


    private
    String time;


    private
    String date;

    private String AppType;

    private boolean isCheck;

    private boolean isCancle;

    public Appointment(String appCode, String time, String date, String appType, boolean isCheck, boolean isCancle) {
        AppCode = appCode;
        this.time = time;
        this.date = date;
        AppType = appType;
        this.isCheck = isCheck;
        this.isCancle = isCancle;
    }

    public boolean isCancle() {
        return isCancle;
    }

    public void setCancle(boolean cancle) {
        isCancle = cancle;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PID",referencedColumnName = "PID")
    private
    Patient patient;

    @ManyToOne
    @JoinColumn(name = "DID",referencedColumnName = "DID")
    private
    Doctor doctor;


    @OneToOne(mappedBy = "appointment",fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private Prescription prescription;

    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }

    public String getAppCode() {
        return AppCode;
    }

    public void setAppCode(String appCode) {
        AppCode = appCode;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAppType() {
        return AppType;
    }

    public void setAppType(String appType) {
        AppType = appType;
    }

    public boolean isCheck() {
        return isCheck;
    }

    public void setCheck(boolean check) {
        isCheck = check;
    }

    public Appointment(String appCode, String time, String date, String appType, boolean isCheck) {
        AppCode = appCode;
        this.time = time;
        this.date = date;
        AppType = appType;
        this.isCheck = isCheck;
    }

    public Appointment() {
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
        return "Appointment{" +
                "AppCode='" + AppCode + '\'' +
                ", time=" + time +
                ", date=" + date +
                ", AppType='" + AppType + '\'' +
                ", isCheck=" + isCheck +
                '}';
    }


}
